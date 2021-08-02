package services;

import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    public Book getBookById(Integer id){
        if (bookRepository.findById(id).isPresent())
            return bookRepository.findById(id).get();
        else return null;
    }

    @Transactional
    public void saveBook(Book book){
        bookRepository.save(book);
    }

    @Transactional
    public void decrementRemainById(Integer id){
        bookRepository.decrementRemainById(id);
    }
}
