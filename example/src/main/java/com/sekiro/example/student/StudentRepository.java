package com.sekiro.example.student;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByFirstnameContaining(String p);
}
