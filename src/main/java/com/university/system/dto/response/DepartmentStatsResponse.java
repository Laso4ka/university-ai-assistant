package com.university.system.dto.response;

import java.math.BigDecimal;

public record DepartmentStatsResponse(
        String departmentName,
        Long studentsCount,
        Long lecturersCount,
        Long coursesCount,
        BigDecimal averageSalary
) {}