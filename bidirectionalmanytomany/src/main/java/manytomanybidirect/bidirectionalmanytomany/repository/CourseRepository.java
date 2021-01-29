package manytomanybidirect.bidirectionalmanytomany.repository;


import manytomanybidirect.bidirectionalmanytomany.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
    public Course findByName(String courseName);
}
