package com.sampleapplication.repository;

import com.sampleapplication.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByBirthDate(LocalDate birthDate);
}
