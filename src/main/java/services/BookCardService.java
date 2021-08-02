package services;

import CustomExecption.CodeNotFound;
import model.BookCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.BookCardRepository;

@Service
public class BookCardService {
    @Autowired
    @Qualifier("bookCardRepository")
    private BookCardRepository bookCardRepository;

    public void saveBookCard(BookCard bookCard){
        bookCardRepository.save(bookCard);
    }

    public BookCard findByCode(Integer code) throws CodeNotFound {
        if(bookCardRepository.findByCode(code)!=null)
            return bookCardRepository.findByCode(code);
        else throw new CodeNotFound();
    }

    @Transactional
    public void deleteByCode(Integer code){
        bookCardRepository.deleteByCode(code);
    }
}
