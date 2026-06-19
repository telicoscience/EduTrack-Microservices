package br.com.telico.classroom_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.telico.classroom_service.dto.CreateClassroomRequest;
import br.com.telico.classroom_service.model.Classroom;
import br.com.telico.classroom_service.service.ClassroomService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/classrooms")
public class ClassroomController {
    private final ClassroomService classroomService;

    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @GetMapping
    public List<Classroom> findAll() {
        return classroomService.findAll();
    }

    @GetMapping("/{id}")
    public Classroom findById(@PathVariable Long id) {
        return classroomService.findById(id);
    }

    @PostMapping
    public Classroom create(@Valid @RequestBody CreateClassroomRequest request) {
        return classroomService.create(request);
    }

    @PutMapping("/{id}")
    public Classroom update(
            @PathVariable Long id,
            @Valid @RequestBody CreateClassroomRequest request
    ) {
        return classroomService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        classroomService.delete(id);
    }
}
