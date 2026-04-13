package com.university.system.dto.response;

import java.time.LocalDateTime;

public record ErrorResponse(
        String message,
        String error,
        LocalDateTime timestamp
) {}