package manytomanybidirect.bidirectionalmanytomany.onetomany.repository;

import manytomanybidirect.bidirectionalmanytomany.onetomany.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer>{
}
