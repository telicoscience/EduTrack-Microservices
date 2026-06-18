package br.com.telico.classroom_service.exception;

public class ClassroomNotFoundException extends RuntimeException {
    public ClassroomNotFoundException(Long id) {
        super("Classroom not found with id: " + id);
    }
}