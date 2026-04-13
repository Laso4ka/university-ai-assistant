package com.university.system.dto.response;

public record AskResponse(
        String answer,
        String toolUsed
) {}