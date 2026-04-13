package com.university.system.dto.response;

import java.math.BigDecimal;
import java.util.List;

public record StudentGradesResponse(
        Long studentId,
        String fullName,
        String department,
        List<CourseGrade> courses,
        BigDecimal gpa
) {
}