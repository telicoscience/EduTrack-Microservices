package br.com.telico.student_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.telico.student_service.model.Student;

// Esse arquivo guarda as regras de negócios sobre os alunos. 
@Service
public class StudentService {

    public List<Student> findAll()
    {
        return List.of(
            new Student(1L, "João"),
            new Student(2L, "Maria")
        );
    }
    
}
