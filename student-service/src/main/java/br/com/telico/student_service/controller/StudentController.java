package br.com.telico.student_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map; 

@RestController
@RequestMapping("/students")
public class StudentController {

    // Criar classe studentController
    // Marcar com @RestController 
    
    // Mapear a classe com @RequestMapping("/students")
    // Criar o método List()
    // Mapear o método com @GetMapping
    @GetMapping
    public List<Map<String, Object>> list(){
        return List.of(Map.of(
            "id", 1,
            "name", "João"
        ),
        Map.of(
            "id", 2,
            "name", "Maria"
        ));
    }
    // Retornar uma lista de alunos fake

    
}
