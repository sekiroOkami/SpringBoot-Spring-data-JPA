package com.sekiro.example.model.school;

import com.sekiro.example.model.student.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {
}
