package br.com.telico.student_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
    // Atributos (estado do objeto )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    

    // Métodos da classe 
    // Construtor vazio
    public Student(){

    }
    // Setters 
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(Long id, String name) {
        this.id = id;
        this.name = name; 
    }

    // Getters - Getter é um tipo de método que serve para ler atributo privado 
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    
    
}
