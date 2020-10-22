package com.sampleapplication.controller;

import com.sampleapplication.domain.Student;
import com.sampleapplication.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PutMapping(value = "/student")
    public void save(@RequestBody Student student) {
        studentService.save(student);
    }

    @GetMapping(value = "/student/{id}")
    public Student getById(@PathVariable("id") long id) {
        return studentService.getById(id);
    }

    @DeleteMapping(value = "/student/{id}")
    public void delete(@PathVariable("id") long id) {
        studentService.delete(id);
    }

    @PostMapping(value = "/student/{id}")
    public void update(@PathVariable("id") long id, @RequestBody Student newStudent) {
        studentService.update(id, newStudent);
    }

    @GetMapping(value = "/students")
    public List<Student> getAllRooms() {
        return studentService.getAllStudents();
    }

    @GetMapping(value = "/students/{Date}")
    public List<Student> getByBirthDate(@PathVariable("Date") LocalDate birthDate) {
        return studentService.getByBirthDate(birthDate);
    }
}
