package br.com.telico.student_service.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.com.telico.student_service.model.Student;
import br.com.telico.student_service.repository.StudentRepository;
import br.com.telico.student_service.exception.StudentNotFoundException;
import br.com.telico.student_service.dto.CreateStudentRequest;

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

    public Student create(CreateStudentRequest request) {
        Student student = new Student();

        student.setName(request.getName());
        student.setCpf(request.getCpf());
        student.setRegistration(request.getRegistration());
        student.setGrade(request.getGrade());
        student.setClassGroup(request.getClassGroup());
        student.setShift(request.getShift());
        student.setStatus(request.getStatus());
        student.setGuardianName(request.getGuardianName());
        student.setAverageScore(request.getAverageScore());
        student.setAttendanceRate(request.getAttendanceRate());

        return studentRepository.save(student);
    }

    

    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    public List<Student> searchByName(String name) {
        return studentRepository.findByNameContainingIgnoreCase(name);
    }



    public Student update(Long id, CreateStudentRequest request) {
        Student student = findById(id);

        student.setName(request.getName());
        student.setCpf(request.getCpf());
        student.setRegistration(request.getRegistration());
        student.setGrade(request.getGrade());
        student.setClassGroup(request.getClassGroup());
        student.setShift(request.getShift());
        student.setStatus(request.getStatus());
        student.setGuardianName(request.getGuardianName());
        student.setAverageScore(request.getAverageScore());
        student.setAttendanceRate(request.getAttendanceRate());

        return studentRepository.save(student);
    }

    public void delete(Long id) {
        Student student = findById(id);
        studentRepository.delete(student);
    }
}
