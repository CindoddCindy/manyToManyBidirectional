package manytomanybidirect.bidirectionalmanytomany.onetomany.repository;

import manytomanybidirect.bidirectionalmanytomany.onetomany.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
