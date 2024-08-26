package com.sekiro.example.controller;

import com.sekiro.example.model.school.SchoolDto;
import com.sekiro.example.model.school.SchoolRepository;
import com.sekiro.example.model.school.SchoolService;
import com.sekiro.example.model.student.School;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SchoolController {
    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping(path = "/schools")
    @ResponseStatus(HttpStatus.CREATED)
    public SchoolDto create(
            @RequestBody SchoolDto dto
    ) {
        return schoolService.create(dto);
    }

    @GetMapping(path = "/schools")
    @ResponseStatus(HttpStatus.CREATED)
    public List<SchoolDto> findALl() {
        return schoolService.findALl();
    }
}
