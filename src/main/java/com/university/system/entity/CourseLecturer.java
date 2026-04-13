package com.university.system.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "course_lecturers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CourseLecturer {

    @EmbeddedId
    private CourseLecturerId id;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @ManyToOne
    @MapsId("lecturerId")
    @JoinColumn(name = "lecturer_id", nullable = false)
    private Lecturer lecturer;
}

