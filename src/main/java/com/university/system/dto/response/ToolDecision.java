package com.university.system.dto.response;

import java.util.Map;

public record ToolDecision(
        String tool,
        Map<String, Object> arguments
) {}