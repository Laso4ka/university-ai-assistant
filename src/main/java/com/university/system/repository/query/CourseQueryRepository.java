package com.university.system.repository.query;

import com.university.system.dto.response.TopStudentResponse;
import com.university.system.dto.response.CourseResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class CourseQueryRepository {

    @PersistenceContext
    private EntityManager em;

    public List<TopStudentResponse> getTopStudents(String courseName, int limit) {

        Query query = em.createNativeQuery("""
            SELECT
                s.id,
                s.first_name,
                s.last_name,
                e.grade
            FROM enrollments e
            JOIN students s ON s.id = e.student_id
            JOIN courses c ON c.id = e.course_id
            WHERE LOWER(c.name) like LOWER(CONCAT('%', :courseName, '%'))
            ORDER BY e.grade DESC
            LIMIT :limit
        """);

        query.setParameter("courseName", courseName);
        query.setParameter("limit", limit);

        List<Object[]> rows = query.getResultList();

        return rows.stream()
                .map(r -> new TopStudentResponse(
                        ((Number) r[0]).longValue(),
                        (String) r[1],
                        (String) r[2],
                        (BigDecimal) r[3]
                ))
                .toList();
    }

    public List<CourseResponse> findCoursesByLecturer(String lecturerName) {

        Query query = em.createNativeQuery("""
            SELECT
                c.id,
                c.name,
                c.code
            FROM course_lecturers cl
            JOIN lecturers l ON l.id = cl.lecturer_id
            JOIN courses c ON c.id = cl.course_id
            WHERE LOWER(l.first_name || ' ' || l.last_name) LIKE LOWER(CONCAT('%', :name, '%'))
        """);

        query.setParameter("name", lecturerName);

        List<Object[]> rows = query.getResultList();

        return rows.stream()
                .map(r -> new CourseResponse(
                        ((Number) r[0]).longValue(),
                        (String) r[1],
                        (String) r[2]
                ))
                .toList();
    }
}