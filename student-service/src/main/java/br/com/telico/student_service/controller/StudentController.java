package br.com.telico.student_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    // Criar classe studentController
    // Marcar com @RestController 
    
    // Mapear a classe com @RequestMapping("/students")
    // Criar o método List()
    // Mapear o método com @GetMapping
    @GetMapping
    public String list(){
        return "Lista de alunos";
    }
    // Retornar uma lista de alunos fake

    
}
