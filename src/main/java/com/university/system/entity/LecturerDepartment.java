package com.university.system.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lecturer_departments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LecturerDepartment {

    @EmbeddedId
    private LecturerDepartmentId id;

    @ManyToOne
    @MapsId("lecturerId")
    @JoinColumn(name = "lecturer_id", nullable = false)
    private Lecturer lecturer;

    @ManyToOne
    @MapsId("departmentId")
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;
}

