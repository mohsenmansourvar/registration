package com.sampleapplication.configuration;

import com.sampleapplication.repository.StudentRepository;
import com.sampleapplication.service.StudentServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public StudentServiceImpl studentService(StudentRepository studentRepository) {
        return new StudentServiceImpl(studentRepository);
    }
}
