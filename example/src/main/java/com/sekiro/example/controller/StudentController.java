package com.sekiro.example.controller;

import com.sekiro.example.model.student.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<StudentResponseDto> findAllStudent() {
        return studentService.studentRepository().findAll().stream()
                .map(student -> new StudentResponseDto(student.getFirstname(), student.getLastname(), student.getEmail()))
                .toList();
    }

    @GetMapping(path = "/students/{student-id}" )
    public StudentResponseDto findStudentById(
            @PathVariable(name = "student-id") Long id
    ) {
        return studentService.findStudentById(id);
    }

    @GetMapping(path = "/students/search/{student-firstname}" )
    public List<StudentResponseDto> findStudentByFirstname(
            @PathVariable(name = "student-firstname") String firstname
    ) {
        return studentService.findStudentByFirstname(firstname);
    }

    @PostMapping("/students")
    public StudentResponseDto saveStudent(
            @RequestBody StudentDTO dto
    ) {
        return studentService.saveStudent(dto);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void deleteStudent(
            @PathVariable(name = "student-id") Long id
    ) {
        studentService.deleteStudent(id);
    }
}
