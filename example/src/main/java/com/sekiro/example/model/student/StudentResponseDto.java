package com.sekiro.example.model.student;

public record StudentResponseDto(
        // hold data that want to expose
        String firstName,
        String lastName,
        String email
) {
}
