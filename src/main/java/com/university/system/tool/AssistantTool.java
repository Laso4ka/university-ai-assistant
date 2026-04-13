package com.university.system.tool;

import java.util.Map;

public interface AssistantTool {

    String getName();

    Object execute(Map<String, Object> input);
}