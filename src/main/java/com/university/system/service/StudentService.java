package com.university.system.service;

import com.university.system.dto.response.StudentGradesResponse;
import com.university.system.entity.Student;
import com.university.system.repository.StudentRepository;
import com.university.system.repository.query.StudentQueryRepository;
import com.university.system.repository.query.dto.StudentGradesData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentQueryRepository queryRepo;
    private final StudentRepository repo;

    public StudentService(StudentQueryRepository queryRepo, StudentRepository repo) {
        this.queryRepo = queryRepo;
        this.repo = repo;
    }

    public  List<StudentGradesResponse> getGrades(String studentName) {
        List<Student> students = repo.searchByFullName(studentName);

        if (students.isEmpty()) {
            throw new IllegalArgumentException("Student not found");
        }

        return (students.stream()
                .map(student -> {
                    StudentGradesData gradesData = queryRepo.getStudentGrades(student.getId());

                    return new StudentGradesResponse(
                            student.getId(),
                            student.getFirstName() + " " + student.getLastName(),
                            student.getDepartment().getName(),
                            gradesData.grades(),
                            gradesData.gpa()
                    );
                })
                .toList());
    }
}