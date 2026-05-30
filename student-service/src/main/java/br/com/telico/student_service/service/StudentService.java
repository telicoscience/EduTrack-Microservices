package br.com.telico.student_service.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.com.telico.student_service.model.Student;
import br.com.telico.student_service.repository.StudentRepository;
import br.com.telico.student_service.exception.StudentNotFoundException;

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
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    public List<Student> searchByName(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }



    public Student update(Long id, String name) {
        Student student = studentRepository.findById(id).orElse(null);

        if (student == null) {
            return null;
        }

        student.setName(name);
        return studentRepository.save(student);
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
