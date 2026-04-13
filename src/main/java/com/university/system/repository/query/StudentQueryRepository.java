package com.university.system.repository.query;

import com.university.system.dto.response.CourseGrade;
import com.university.system.repository.query.dto.StudentGradesData;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class StudentQueryRepository {

    @PersistenceContext
    private EntityManager em;

    public StudentGradesData getStudentGrades(Long studentId) {

        Query query = em.createNativeQuery("""
            SELECT
                c.name,
                e.grade
            FROM enrollments e
            JOIN courses c ON c.id = e.course_id
            WHERE e.student_id = :studentId
       \s""");

        query.setParameter("studentId", studentId);

        List<Object[]> rows = query.getResultList();

        List<CourseGrade> grades = rows.stream()
                .map(r -> new CourseGrade(
                        (String) r[0],
                        (BigDecimal) r[1]
                ))
                .toList();

        Query gpaQuery = em.createNativeQuery("""
            SELECT COALESCE(AVG(e.grade), 0)
            FROM enrollments e
            WHERE e.student_id = :studentId
        """);

        gpaQuery.setParameter("studentId", studentId);

        BigDecimal gpa = (BigDecimal) gpaQuery.getSingleResult();

        return new StudentGradesData(grades, gpa);
    }
}