package com.university.system.service;

import com.university.system.dto.response.PersonSearchResponse;
import com.university.system.dto.response.PersonSearchResponse.PersonDto;
import com.university.system.repository.LecturerRepository;
import com.university.system.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    private final StudentRepository studentRepo;
    private final LecturerRepository lecturerRepo;

    public SearchService(StudentRepository studentRepo, LecturerRepository lecturerRepo) {
        this.studentRepo = studentRepo;
        this.lecturerRepo = lecturerRepo;
    }

    public PersonSearchResponse search(String query) {

        List<PersonDto> students = studentRepo
                .searchByFullName(query)
                .stream()
                .map(s -> new PersonDto(s.getId(), s.getFirstName(), s.getLastName()))
                .collect(Collectors.toList());

        List<PersonDto> lecturers = lecturerRepo
                .searchByFullName(query)
                .stream()
                .map(l -> new PersonDto(l.getId(), l.getFirstName(), l.getLastName()))
                .collect(Collectors.toList());

        return new PersonSearchResponse(students, lecturers);
    }
}