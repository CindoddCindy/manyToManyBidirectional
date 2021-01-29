package manytomanybidirect.bidirectionalmanytomany.repository;




import manytomanybidirect.bidirectionalmanytomany.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
}
