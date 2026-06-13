package br.com.telico.classroom_service.service;
import java.util.List;
import org.springframework.stereotype.Service;

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
    
}
