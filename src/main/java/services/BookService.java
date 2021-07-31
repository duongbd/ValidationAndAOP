package services;

import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import repository.BookRepository;

import java.util.List;

@Service("bookService")
public class BookService {
    @Autowired
    @Qualifier("bookRepository")
    private BookRepository bookRepository;

    public List<Book> getListBook(){
        return bookRepository.findAll();
    }
}
