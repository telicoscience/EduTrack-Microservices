package br.com.telico.student_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
@RestController
@RequestMapping("/students")
public class StudentController {

    // Endpoint responsável por listar alunos temporários em memória.
    @GetMapping
    public List<Map<String, Object>> list() {
        return List.of(
            Map.of(
                "id", 1,
                "name", "João"
            ),
            Map.of(
                "id", 2,
                "name", "Maria"
            )
        );
    }
    @GetMapping("/{id}")
    public Map<String, Object> getStudentById(@PathVariable long id){
        return Map.of("id", id, 
                       "name", "João"       
        ); 
    }

    // Criar um novo método chamado searchByName
    @GetMapping("/search")
    public List<Map<String,Object>> searchByName(@RequestParam String name){
        return List.of(Map.of("id", 1, "name", name));
    }

    // Criar um método create 
    @PostMapping 
    public Map<String, Object> create( @RequestBody Map<String, Object> body)
    {
        return Map.of("id", 3, "name", body.get("name"));
    }
}
