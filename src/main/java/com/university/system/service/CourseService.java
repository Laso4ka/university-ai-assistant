package com.university.system.service;

import com.university.system.dto.response.CourseResponse;
import com.university.system.dto.response.TopStudentResponse;
import com.university.system.repository.query.CourseQueryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseQueryRepository repo;

    public CourseService(CourseQueryRepository repo) {
        this.repo = repo;
    }

    public List<TopStudentResponse> getTopStudents(String courseName, int limit) {
        return repo.getTopStudents(courseName, limit);
    }

    public List<CourseResponse> findCoursesByLecturer(String name) {
        return repo.findCoursesByLecturer(name);
    }
}