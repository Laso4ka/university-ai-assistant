package com.university.system.dto.response;

import java.math.BigDecimal;

public record CourseGrade(
        String courseName,
        BigDecimal grade
) {}