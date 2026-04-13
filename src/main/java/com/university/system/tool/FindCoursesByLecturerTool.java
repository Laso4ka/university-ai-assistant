package com.university.system.tool;

import com.university.system.service.CourseService;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class FindCoursesByLecturerTool implements AssistantTool {

    private final CourseService service;

    public FindCoursesByLecturerTool(CourseService service) {
        this.service = service;
    }

    @Override
    public String getName() {
        return ToolName.FIND_COURSES_BY_LECTURER.name();
    }

    @Override
    public Object execute(Map<String, Object> input) {
        String name = (String) input.get("lecturerName");

        return service.findCoursesByLecturer(name);
    }
}