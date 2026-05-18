package br.com.telico.student_service.model;

public class Student {
    // Atributos (estado do objeto )
    private Long id;
    private String name; 

    // Métodos da classe 
    // Construtor vazio
    public Student(){

    }

    public Student(Long id, String name)
    {
        this.id = id;
        this.name = name; 
    }

    // Getters - Getter é um tipo de método que serve para ler atributo privado 
    public Long getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    
    
}
