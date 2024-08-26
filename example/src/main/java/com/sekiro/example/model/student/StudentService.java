package com.sekiro.example.model.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public record StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {

    public StudentResponseDto saveStudent(StudentDTO dto) {
        var student = studentMapper().toStudent(dto);
        var savedStudent = studentRepository().save(student);
        return studentMapper().toStudentResponseDto(savedStudent);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public List<StudentResponseDto> findStudentByFirstname(String firstname) {
        return studentRepository.findAllByFirstnameContaining(firstname).stream()
                .map(studentMapper::toStudentResponseDto).toList();
    }

    public StudentResponseDto findStudentById(Long id) {
        return studentRepository.findById(id)
                .map(studentMapper::toStudentResponseDto)
                .orElse(null);

    }
}
