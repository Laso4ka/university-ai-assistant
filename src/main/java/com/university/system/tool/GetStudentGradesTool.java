package com.university.system.tool;

import com.university.system.service.StudentService;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GetStudentGradesTool implements AssistantTool {

    private final StudentService service;

    public GetStudentGradesTool(StudentService service) {
        this.service = service;
    }

    @Override
    public String getName() {
        return ToolName.GET_STUDENT_GRADES.name();
    }

    @Override
    public Object execute(Map<String, Object> input) {
        String studentName = (String) input.get("studentName");

        return service.getGrades(studentName);
    }
}