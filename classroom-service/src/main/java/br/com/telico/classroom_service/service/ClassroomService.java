package br.com.telico.classroom_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.telico.classroom_service.dto.CreateClassroomRequest;
import br.com.telico.classroom_service.exception.ClassroomNotFoundException;
import br.com.telico.classroom_service.model.Classroom;
import br.com.telico.classroom_service.repository.ClassroomRepository;

@Service
public class ClassroomService {

    private final ClassroomRepository classroomRepository;

    public ClassroomService(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    public List<Classroom> findAll() {
        return classroomRepository.findAll();
    }

    public Classroom findById(Long id) {
        return classroomRepository.findById(id)
                .orElseThrow(() -> new ClassroomNotFoundException(id));
    }

    public Classroom create(CreateClassroomRequest request) {
        Classroom classroom = new Classroom(
                null,
                request.getName(),
                request.getGrade(),
                request.getSchoolYear(),
                request.getShift(),
                request.getCapacity()
        );

        return classroomRepository.save(classroom);
    }

    public Classroom update(Long id, CreateClassroomRequest request) {
        Classroom classroom = findById(id);

        classroom.setName(request.getName());
        classroom.setGrade(request.getGrade());
        classroom.setSchoolYear(request.getSchoolYear());
        classroom.setShift(request.getShift());
        classroom.setCapacity(request.getCapacity());

        return classroomRepository.save(classroom);
    }

    public void delete(Long id) {
        Classroom classroom = findById(id);
        classroomRepository.delete(classroom);
    }
}