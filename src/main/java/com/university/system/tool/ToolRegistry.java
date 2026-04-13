package com.university.system.tool;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ToolRegistry {

    private final Map<String, AssistantTool> tools;

    public ToolRegistry(List<AssistantTool> tools) {
        this.tools = tools.stream()
                .collect(Collectors.toMap(AssistantTool::getName, t -> t));
    }

    public AssistantTool getTool(String name) {
        return tools.get(name);
    }
}