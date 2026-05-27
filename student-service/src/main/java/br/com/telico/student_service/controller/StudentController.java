package br.com.telico.student_service.controller;

import br.com.telico.student_service.model.Student;
import br.com.telico.student_service.service.StudentService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.telico.student_service.dto.CreateStudentRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> list() {
        return studentService.findAll();
    }

    @GetMapping("/search")
    public List<Student> searchByName(@RequestParam String name) {
        return studentService.searchByName(name);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @PostMapping
    public Student create(@Valid @RequestBody CreateStudentRequest request) {
        String name = request.getName().toString();
        return studentService.create(name);
    }
}