package br.com.telico.student_service.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateStudentRequest {
    @NotBlank
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
