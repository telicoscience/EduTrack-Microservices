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
import br.com.telico.student_service.model.Student;
import br.com.telico.student_service.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
    // Cria um atributo de classe chamado studentService
    private final StudentService studentService;

    // Cria um construtor 
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

   @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.findById(id);
}
    
    // Criar um novo método chamado searchByName
    @GetMapping("/search")
    public List<Student> searchByName(@RequestParam String name){
        return List.of(new Student(1L, name));
    }

    // Criar um método create 
    @PostMapping 
    public Student create( @RequestBody Map<String, Object> body)
    {
        String name = body.get("name").toString();
        return new Student(3L, name);
    }

}
