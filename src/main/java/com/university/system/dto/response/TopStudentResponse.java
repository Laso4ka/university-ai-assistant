package com.university.system.dto.response;

import java.math.BigDecimal;

public record TopStudentResponse(
        Long studentId,
        String firstName,
        String lastName,
        BigDecimal grade
) {}