package repository;

import model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository(value = "bookRepository")
public interface BookRepository extends JpaRepository<Book,Integer> {
}
