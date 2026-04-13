package com.university.system.repository.query.dto;

import com.university.system.dto.response.CourseGrade;

import java.math.BigDecimal;
import java.util.List;

public record StudentGradesData(
        List<CourseGrade> grades,
        BigDecimal gpa
) {}