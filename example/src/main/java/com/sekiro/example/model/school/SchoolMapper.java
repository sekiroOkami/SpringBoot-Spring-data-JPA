package com.sekiro.example.model.school;

import com.sekiro.example.model.student.School;
import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {
    public SchoolDto toSchoolDto(School school) {
        return new SchoolDto(school.getName());
    }

    public School toSchool(SchoolDto dto) {
        return new School(dto.schoolName());
    }
}
