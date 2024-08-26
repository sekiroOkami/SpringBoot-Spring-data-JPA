package com.sekiro.example.model.school;

import com.sekiro.example.model.student.School;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record SchoolService(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {

    public SchoolDto create(SchoolDto dto) {
        var school = schoolMapper.toSchool(dto);
        schoolRepository.save(school);
        return dto;
    }

    public List<SchoolDto> findALl() {
        return
        schoolRepository.findAll().stream()
                .map(schoolMapper::toSchoolDto)
                .toList();
    }

}
