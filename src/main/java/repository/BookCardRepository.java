package repository;

import model.BookCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("bookCardRepository")
public interface BookCardRepository extends JpaRepository<BookCard,Integer> {
    BookCard findByCode(Integer code);
    void deleteByCode(Integer code);
}
