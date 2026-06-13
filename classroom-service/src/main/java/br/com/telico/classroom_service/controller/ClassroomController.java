package br.com.telico.classroom_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.telico.classroom_service.model.Classroom;
import br.com.telico.classroom_service.service.ClassroomService;

@RestController
public class ClassroomController {
    private final ClassroomService classroomService;

    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @GetMapping("/classrooms")
    public List<Classroom> findAll() {
        return classroomService.findAll();
    }

    @GetMapping("/classrooms/{id}")
    public Classroom findById(@PathVariable Long id) {
        return classroomService.findById(id);
    }
}
