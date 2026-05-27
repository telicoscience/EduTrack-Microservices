package br.com.telico.student_service.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.telico.student_service.model.Student;

public class StudentServiceTest {

    @Test
    void shouldReturnAllStudents() {
        StudentService service = new StudentService();

        List<Student> students = service.findAll();

        assertEquals(2, students.size());
        assertEquals("João", students.get(0).getName());
    }

    @Test
    void shouldReturnStudentById() {
        StudentService service = new StudentService();

        Student student = service.findById(7L);
        assertEquals(7L, student.getId());
        assertEquals("João", student.getName());

    }

    @Test
    void shouldSearchStudentByName() {
        StudentService service  = new StudentService();

        List<Student> students = service.searchByName("Ana");

        assertEquals(1, students.size());
        assertEquals("Ana", students.get(0).getName());

    }

    @Test
    void shouldCreateStudent() {
        StudentService service = new StudentService();
        Student student = service.create("Carlos");
        
        assertEquals(3L, student.getId());
        assertEquals("Carlos", student.getName());

    }
}