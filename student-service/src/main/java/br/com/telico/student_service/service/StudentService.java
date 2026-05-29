package br.com.telico.student_service.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.com.telico.student_service.model.Student;
import br.com.telico.student_service.repository.StudentRepository;

// Esse arquivo guarda as regras de negócios sobre os alunos. 
@Service
public class StudentService {
   private final StudentRepository studentRepository;

   public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
    }
        


    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student create(String name) {
        Student student = new Student(null, name);
        return studentRepository.save(student);
    }

    

    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> searchByName(String name) {
        return List.of(
            new Student(1L, name)
        );
    }
}