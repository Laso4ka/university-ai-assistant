package com.university.system.dto.request;

import jakarta.validation.constraints.NotBlank;

public record AskRequest(
        @NotBlank
        String question
) {}