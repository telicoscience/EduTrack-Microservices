package br.com.telico.student_service.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.telico.student_service.model.Student;
import br.com.telico.student_service.repository.StudentRepository;
import br.com.telico.student_service.dto.CreateStudentRequest;
import br.com.telico.student_service.exception.StudentNotFoundException;

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
            new Student(
                3L,
                "Carlos",
                "12345678900",
                "2026001",
                "8th grade",
                "A",
                "Morning",
                "Active",
                "Maria Silva",
                8.7,
                96.5
            )
        );

        Student student = service.create(createRequest("Carlos"));

        assertEquals(3L, student.getId());
        assertEquals("Carlos", student.getName());
        assertEquals("12345678900", student.getCpf());
        assertEquals("2026001", student.getRegistration());
    }

    @Test
    void shouldUpdateStudent() {
        StudentRepository repository = Mockito.mock(StudentRepository.class);
        StudentService service = new StudentService(repository);
        Student existingStudent = new Student(1L, "José");

        when(repository.findById(1L)).thenReturn(Optional.of(existingStudent));
        when(repository.save(Mockito.any(Student.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Student updatedStudent = service.update(1L, createRequest("José Atualizado"));

        assertEquals(1L, updatedStudent.getId());
        assertEquals("José Atualizado", updatedStudent.getName());
        assertEquals("12345678900", updatedStudent.getCpf());
        assertEquals("2026001", updatedStudent.getRegistration());
        assertEquals("8th grade", updatedStudent.getGrade());
    }

    @Test
    void shouldDeleteStudent() {
        StudentRepository repositoty = Mockito.mock(StudentRepository.class);
        StudentService service = new StudentService(repositoty);

        Student existingStudent = new Student(1L, "José");
        
        when(repositoty.findById(1L)).thenReturn(Optional.of(existingStudent));

        service.delete(1L);
        verify(repositoty).delete(existingStudent);       
    }

    @Test
    void shouldThrowStudentNotFoundExceptionWhenDeletingMissingStudent() {
        StudentRepository repository = Mockito.mock(StudentRepository.class);
        StudentService service = new StudentService(repository);

        when(repository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(StudentNotFoundException.class, () -> service.delete(999L));

    }

    private CreateStudentRequest createRequest(String name) {
        CreateStudentRequest request = new CreateStudentRequest();

        request.setName(name);
        request.setCpf("12345678900");
        request.setRegistration("2026001");
        request.setGrade("8th grade");
        request.setClassGroup("A");
        request.setShift("Morning");
        request.setStatus("Active");
        request.setGuardianName("Maria Silva");
        request.setAverageScore(8.7);
        request.setAttendanceRate(96.5);

        return request;
    }
}
