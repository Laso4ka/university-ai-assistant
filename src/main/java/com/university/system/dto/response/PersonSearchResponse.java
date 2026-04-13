package com.university.system.dto.response;

import java.util.List;

public record PersonSearchResponse(
        List<PersonDto> students,
        List<PersonDto> lecturers
) {

    public record PersonDto(
            Long id,
            String firstName,
            String lastName
    ) {}
}