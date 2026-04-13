package com.university.system.tool;

import com.university.system.service.DepartmentService;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GetDepartmentStatsTool implements AssistantTool {

    private final DepartmentService service;

    public GetDepartmentStatsTool(DepartmentService service) {
        this.service = service;
    }

    @Override
    public String getName() {
        return ToolName.GET_DEPARTMENT_STATS.name();
    }

    @Override
    public Object execute(Map<String, Object> input) {
        String name = (String) input.get("departmentName");
        return service.getStats(name);
    }
}