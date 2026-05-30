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
    private String cpf;
    private String registration;
    private String grade;
    private String classGroup;
    private String shift;
    private String status;
    private String guardianName;
    private Double averageScore;
    private Double attendanceRate;
    

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

    public Student(Long id, String name, String cpf, String registration, String grade, String classGroup,
            String shift, String status, String guardianName, Double averageScore, Double attendanceRate) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.registration = registration;
        this.grade = grade;
        this.classGroup = classGroup;
        this.shift = shift;
        this.status = status;
        this.guardianName = guardianName;
        this.averageScore = averageScore;
        this.attendanceRate = attendanceRate;
    }

    // Setters 
    public void setCpf(String cpf) {
    this.cpf = cpf;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setClassGroup(String classGroup) {
        this.classGroup = classGroup;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
    }

    public void setAttendanceRate(Double attendanceRate) {
        this.attendanceRate = attendanceRate;
    }
        
    // Getters - Getter é um tipo de método que serve para ler atributo privado 
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRegistration() {
        return registration;
    }

    public String getGrade() {
        return grade;
    }

    public String getClassGroup() {
        return classGroup;
    }

    public String getShift() {
        return shift;
    }

    public String getStatus() {
        return status;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public Double getAttendanceRate() {
        return attendanceRate;
    }
}
