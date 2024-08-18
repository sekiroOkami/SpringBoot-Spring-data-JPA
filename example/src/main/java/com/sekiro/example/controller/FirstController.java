package com.sekiro.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.sekiro.example.student.Student;
import com.sekiro.example.student.StudentRepository;

import java.util.List;

@RestController
public class FirstController {

    private final StudentRepository studentRepository;


    public FirstController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students")
    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    @GetMapping(path = "/students/{student-id}" )
    public Student findStudentById(
            @PathVariable(name = "student-id") Long id
    ) {
        return studentRepository.findById(id).orElse(null);
    }

    @GetMapping(path = "/students/search/{student-firstname}" )
    public List<Student> findStudentByFirstname(
            @PathVariable(name = "student-firstname") String firstname
    ) {
        return studentRepository.findAllByFirstnameContaining(firstname);
    }

    @PostMapping("/students")
    public Student post(
            @RequestBody Student student
    ) {
        return studentRepository.save(student);
    }

    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void delete(
            @PathVariable(name = "student-id") Long id
    ) {
        studentRepository.deleteById(id);
    }
}
