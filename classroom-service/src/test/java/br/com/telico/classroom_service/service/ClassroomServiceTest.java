package br.com.telico.classroom_service.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.telico.classroom_service.dto.CreateClassroomRequest;
import br.com.telico.classroom_service.exception.ClassroomNotFoundException;
import br.com.telico.classroom_service.model.Classroom;
import br.com.telico.classroom_service.repository.ClassroomRepository;

public class ClassroomServiceTest {

    @Test
    void shouldReturnAllClassrooms() {
        ClassroomRepository repository = Mockito.mock(ClassroomRepository.class);
        ClassroomService service = new ClassroomService(repository);

        when(repository.findAll()).thenReturn(List.of(
            new Classroom(1L, "A", "8th grade", 2026, "Morning", 35),
            new Classroom(2L, "B", "9th grade", 2026, "Afternoon", 40)
        ));

        List<Classroom> classrooms = service.findAll();

        assertEquals(2, classrooms.size());
        assertEquals("A", classrooms.get(0).getName());
    }

    @Test
    void shouldReturnClassroomById() {
        ClassroomRepository repository = Mockito.mock(ClassroomRepository.class);
        ClassroomService service = new ClassroomService(repository);

        when(repository.findById(1L)).thenReturn(Optional.of(
            new Classroom(1L, "A", "8th grade", 2026, "Morning", 35)
        ));

        Classroom classroom = service.findById(1L);

        assertEquals(1L, classroom.getId());
        assertEquals("A", classroom.getName());
    }

    @Test
    void shouldCreateClassroom() {
        ClassroomRepository repository = Mockito.mock(ClassroomRepository.class);
        ClassroomService service = new ClassroomService(repository);

        when(repository.save(Mockito.any(Classroom.class))).thenReturn(
            new Classroom(1L, "A", "8th grade", 2026, "Morning", 35)
        );

        Classroom classroom = service.create(createRequest("A"));

        assertEquals(1L, classroom.getId());
        assertEquals("A", classroom.getName());
        assertEquals("8th grade", classroom.getGrade());
        assertEquals(2026, classroom.getSchoolYear());
    }

    @Test
    void shouldUpdateClassroom() {
        ClassroomRepository repository = Mockito.mock(ClassroomRepository.class);
        ClassroomService service = new ClassroomService(repository);

        Classroom existingClassroom = new Classroom(1L, "A", "8th grade", 2026, "Morning", 35);

        when(repository.findById(1L)).thenReturn(Optional.of(existingClassroom));
        when(repository.save(Mockito.any(Classroom.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Classroom updatedClassroom = service.update(1L, createRequest("B"));

        assertEquals(1L, updatedClassroom.getId());
        assertEquals("B", updatedClassroom.getName());
        assertEquals("8th grade", updatedClassroom.getGrade());
        assertEquals(2026, updatedClassroom.getSchoolYear());
        assertEquals("Morning", updatedClassroom.getShift());
        assertEquals(35, updatedClassroom.getCapacity());
    }

    @Test
    void shouldDeleteClassroom() {
        ClassroomRepository repository = Mockito.mock(ClassroomRepository.class);
        ClassroomService service = new ClassroomService(repository);

        Classroom existingClassroom = new Classroom(1L, "A", "8th grade", 2026, "Morning", 35);

        when(repository.findById(1L)).thenReturn(Optional.of(existingClassroom));

        service.delete(1L);

        verify(repository).delete(existingClassroom);
    }

    @Test
    void shouldThrowClassroomNotFoundExceptionWhenClassroomDoesNotExist() {
        ClassroomRepository repository = Mockito.mock(ClassroomRepository.class);
        ClassroomService service = new ClassroomService(repository);

        when(repository.findById(999L)).thenReturn(Optional.empty());

        assertThrows(
            ClassroomNotFoundException.class,
            () -> service.findById(999L)
        );
    }

    private CreateClassroomRequest createRequest(String name) {
        CreateClassroomRequest request = new CreateClassroomRequest();

        request.setName(name);
        request.setGrade("8th grade");
        request.setSchoolYear(2026);
        request.setShift("Morning");
        request.setCapacity(35);

        return request;
    }
}