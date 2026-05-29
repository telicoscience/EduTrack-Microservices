package br.com.telico.student_service.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.telico.student_service.model.Student;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long>{
    List<Student> findByNameContainingIgnoreCase(String name);
    
}
