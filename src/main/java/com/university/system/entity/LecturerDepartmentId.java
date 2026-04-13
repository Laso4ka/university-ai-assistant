package com.university.system.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

class LecturerDepartmentId {

    private Long lecturerId;

    private Long departmentId;
}
