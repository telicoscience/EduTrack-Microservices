package br.com.telico.student_service.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.telico.student_service.model.Student;
import br.com.telico.student_service.repository.StudentRepository;
import br.com.telico.student_service.dto.CreateStudentRequest;

public class StudentServiceTest {

    @Test
    void shouldReturnAllStudents() {
        StudentRepository repository = Mockito.mock(StudentRepository.class);
        StudentService service = new StudentService(repository);

        when(repository.findAll()).thenReturn(List.of(
            new Student(1L, "João"),
            new Student(2L, "Maria")
        ));

        List<Student> students = service.findAll();

        assertEquals(2, students.size());
        assertEquals("João", students.get(0).getName());
    }

    @Test
    void shouldReturnStudentById() {
        StudentRepository repository = Mockito.mock(StudentRepository.class);
        StudentService service = new StudentService(repository);

        when(repository.findById(7L)).thenReturn(Optional.of(
            new Student(7L, "João")
        ));

        Student student = service.findById(7L);

        assertEquals(7L, student.getId());
        assertEquals("João", student.getName());
    }

    @Test
    void shouldSearchStudentByName() {
        StudentRepository repository = Mockito.mock(StudentRepository.class);
        StudentService service = new StudentService(repository);

        when(repository.findByNameContainingIgnoreCase("Ana")).thenReturn(List.of(
            new Student(1L, "Ana")
        ));

        List<Student> students = service.searchByName("Ana");

        assertEquals(1, students.size());
        assertEquals("Ana", students.get(0).getName());
    }

    @Test
    void shouldCreateStudent() {
        StudentRepository repository = Mockito.mock(StudentRepository.class);
        StudentService service = new StudentService(repository);

        when(repository.save(Mockito.any(Student.class))).thenReturn(
            new Student(3L, "Carlos")
        );

        CreateStudentRequest request = new CreateStudentRequest();
        request.setName("Carlos");

        Student student = service.create(request);

        assertEquals(3L, student.getId());
        assertEquals("Carlos", student.getName());
    }

    @Test
    void shouldUpdateStudent() {
        StudentRepository repository = Mockito.mock(StudentRepository.class);
        StudentService service = new StudentService(repository);
        Student existingStudent = new Student(3L, "Carlos");

        when(repository.findById(3L)).thenReturn(Optional.of(existingStudent));
        when(repository.save(existingStudent)).thenReturn(existingStudent);

        CreateStudentRequest request = new CreateStudentRequest();
        request.setName("Carla");
        request.setRegistration("2026-001");

        Student student = service.update(3L, request);

        assertEquals(3L, student.getId());
        assertEquals("Carla", student.getName());
        assertEquals("2026-001", student.getRegistration());
    }

    @Test
    void shouldDeleteStudent() {
        
    }


}
