package com.university.system.repository.query;

import com.university.system.dto.response.DepartmentStatsResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentQueryRepository {

    @PersistenceContext
    private EntityManager em;

    public DepartmentStatsResponse getDepartmentStats(String departmentName) {

        Query query = em.createNativeQuery("""
            SELECT
                d.name,
                COUNT(DISTINCT s.id) as students_count,
                COUNT(DISTINCT ld.lecturer_id) as lecturers_count,
                COUNT(DISTINCT c.id) as courses_count,
                COALESCE(AVG(l.salary), 0) as avg_salary
            FROM departments d
            LEFT JOIN students s ON s.department_id = d.id
            LEFT JOIN courses c ON c.department_id = d.id
            LEFT JOIN lecturer_departments ld ON ld.department_id = d.id
            LEFT JOIN lecturers l ON l.id = ld.lecturer_id
            WHERE LOWER(d.name) = LOWER(:name)
            GROUP BY d.name
        """);

        query.setParameter("name", departmentName);

        Object[] row = (Object[]) query.getSingleResult();

        return new DepartmentStatsResponse(
                (String) row[0],
                ((Number) row[1]).longValue(),
                ((Number) row[2]).longValue(),
                ((Number) row[3]).longValue(),
                (java.math.BigDecimal) row[4]
        );
    }
}