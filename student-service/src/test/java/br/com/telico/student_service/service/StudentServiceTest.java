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
}