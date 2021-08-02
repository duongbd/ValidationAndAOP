package repository;

import model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository(value = "bookRepository")
public interface BookRepository extends JpaRepository<Book,Integer> {
    @Modifying
    @Query("update Book u set u.remain = u.remain - 1 where u.id = :bookId")
    void decrementRemainById(@Param("bookId") Integer bookId);
}
