package br.com.telico.student_service.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.telico.student_service.model.Student;

// Esse arquivo guarda as regras de negócios sobre os alunos. 


@Service
public class StudentService {
     // Endpoint responsável por listar alunos temporários em memória.
    @GetMapping
    public List<Student> list() {
        return findAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable Long id){
        return new Student(id, "João");
    }



    public List<Student> findAll()
    {
        return List.of(
            new Student(1L, "João"),
            new Student(2L, "Maria")
        );
    }
    
}
