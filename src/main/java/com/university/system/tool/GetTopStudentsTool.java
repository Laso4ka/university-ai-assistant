package com.university.system.tool;

import com.university.system.service.CourseService;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GetTopStudentsTool implements AssistantTool {

    private final CourseService service;

    public GetTopStudentsTool(CourseService service) {
        this.service = service;
    }

    @Override
    public String getName() {
        return ToolName.GET_TOP_STUDENTS.name();
    }

    @Override
    public Object execute(Map<String, Object> input) {
        String courseName = input.get("courseName").toString();
        int limit = Integer.parseInt(input.get("limit").toString());

        return service.getTopStudents(courseName, limit);
    }
}