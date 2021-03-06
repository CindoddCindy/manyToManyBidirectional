package manytomanybidirect.bidirectionalmanytomany.onetomany.repository;

import manytomanybidirect.bidirectionalmanytomany.model.Course;
import manytomanybidirect.bidirectionalmanytomany.onetomany.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
    Page<Book> findByLibraryId(Integer libraryId, Pageable pageable);

    public Book findByName(String bookName);


    @Modifying
    @Transactional
    @Query("DELETE FROM Book b WHERE b.library.id = ?1")
    void deleteByLibraryId(Integer libraryId);


}
