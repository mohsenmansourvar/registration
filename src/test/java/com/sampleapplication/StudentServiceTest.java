package com.sampleapplication;

import com.sampleapplication.domain.Student;
import com.sampleapplication.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    void save() {
        Student student = createStudent();

        studentService.save(student);

        Student studentById = studentService.getById(student.getId());


        assertNotNull(studentById);
        assertEquals("Mohsen", studentById.getFirstName());
        assertEquals("Mansouri", studentById.getLastName());
        assertEquals(LocalDate.now(), studentById.getBirthDate());
    }

    @Test
    void delete() {
        Student student = createStudent();
        studentService.save(student);

        studentService.delete(student.getId());

        assertThrows(IllegalArgumentException.class, () -> studentService.getById(student.getId()));
    }

    @Test
    void getById() {
        Student student = createStudent();
        studentService.save(student);

        Student studentById = studentService.getById(student.getId());

        assertNotNull(studentById);
        assertEquals("Mohsen", studentById.getFirstName());
        assertEquals("Mansouri", studentById.getLastName());
        assertEquals(LocalDate.now(), studentById.getBirthDate());
    }

    @Test
    void update() {
        Student student = createStudent();
        studentService.save(student);

        Student updatedStudent = Student.builder()
                .lastName("Mansoury")
                .build();

        studentService.update(student.getId(), updatedStudent);

        Student studentById = studentService.getById(student.getId());

        assertNotNull(studentById);
        assertEquals("Mohsen", studentById.getFirstName());
        assertEquals("Mansoury", studentById.getLastName());
    }

    @Test
    void getAllStudents() {
        Student student1 = createStudent();
        studentService.save(student1);

        Student student2 = Student.builder()
                .firstName("Liam")
                .lastName("Mansouri")
                .birthDate(LocalDate.now())
                .build();
        studentService.save(student2);

        List<Student> allStudent = studentService.getAllStudents();

        assertEquals(2, allStudent.size());
    }

    @Test
    void getByBirthDate() {
        Student student = createStudent();
        studentService.save(student);

        List<Student> studentByBirthDate = studentService.getByBirthDate(LocalDate.now());
        Student student1 = studentByBirthDate.get(0);

        assertNotNull(studentByBirthDate);
        assertEquals(LocalDate.now(), student1.getBirthDate());
    }

    @Test
    private Student createStudent() {
        return Student.builder()
                .firstName("Mohsen")
                .lastName("Mansouri")
                .birthDate(LocalDate.now())
                .build();
    }
}
