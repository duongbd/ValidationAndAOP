package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import repository.BookCardRepository;

@Service
public class BookCardService {
    @Autowired
    @Qualifier("bookCardRepository")
    private BookCardRepository bookCardRepository;
}
