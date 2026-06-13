package br.com.telico.classroom_service.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.telico.classroom_service.model.Classroom;



public interface ClassroomRepository extends JpaRepository<Classroom, Long>  {

    
}

