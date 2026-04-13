package com.university.system.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
class CourseLecturerId {

    private Long courseId;

    private Long lecturerId;
}
