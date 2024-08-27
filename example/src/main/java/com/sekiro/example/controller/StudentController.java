package com.sekiro.example.controller;

import com.sekiro.example.model.student.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
           @Valid @RequestBody StudentDTO dto
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exp
    ) {
        Map<String, String> errors = exp.getBindingResult().getAllErrors().stream()
                .filter(objectError -> objectError instanceof FieldError)
                .map(objectError -> (FieldError) objectError)
                .collect(Collectors.toMap(
                        FieldError::getField,
                        FieldError::getDefaultMessage
                ));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
