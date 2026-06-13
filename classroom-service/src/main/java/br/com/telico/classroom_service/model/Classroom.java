package br.com.telico.classroom_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="classrooms")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // A, B, C
    private String grade; //8° ano
    private Integer schoolYear; // 2026
    private String shift; // Morning
    private Integer capacity;

    public Classroom() {

    }

    public Classroom(Long id, String name, String grade, Integer schoolYear, String shift, Integer capacity) {
        this.id = id; 
        this.name = name; 
        this.grade = grade; 
        this.schoolYear = schoolYear;
        this.shift = shift;
        this.capacity = capacity;
    }

    // Getters e setters 
    
    
}
