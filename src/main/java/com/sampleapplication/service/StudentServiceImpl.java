package com.sampleapplication.service;

import com.sampleapplication.domain.Student;
import com.sampleapplication.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    @Transactional
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    @Transactional
    public void update(long id, Student newStudent) {
        Student student = getById(id);

        if (newStudent.getFirstName() != null) {
            student.setFirstName(newStudent.getFirstName());
        }
        if (newStudent.getLastName() != null) {
            student.setLastName(newStudent.getLastName());
        }
        if (newStudent.getBirthDate() != null) {
            student.setBirthDate(newStudent.getBirthDate());
        }
        studentRepository.save(student);
    }

    @Override
    @Transactional
    public void delete(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student getById(long id) {
        return studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No Student by id"));
    }

    @Override
    public List<Student> getByBirthDate(LocalDate birthDate) {
        return studentRepository.findByBirthDate(birthDate);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
