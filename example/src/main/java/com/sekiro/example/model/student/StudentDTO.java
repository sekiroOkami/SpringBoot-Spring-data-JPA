package com.sekiro.example.model.student;

import jakarta.persistence.Column;

public record StudentDTO(
        String firstname,
        String lastname,
        String email,
        Integer schoolId
) {
}
