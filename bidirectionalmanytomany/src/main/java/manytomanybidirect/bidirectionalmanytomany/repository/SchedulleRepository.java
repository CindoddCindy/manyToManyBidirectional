package manytomanybidirect.bidirectionalmanytomany.repository;

import manytomanybidirect.bidirectionalmanytomany.model.Schedulle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface SchedulleRepository extends JpaRepository<Schedulle, Integer> {
    public Schedulle findByName(String schedulleName);
}
