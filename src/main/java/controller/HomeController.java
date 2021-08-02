package controller;

import CustomExecption.CodeNotFound;
import CustomExecption.OutOfBooks;
import model.Book;
import model.BookCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import services.BookCardService;
import services.BookService;

import javax.validation.Valid;
import java.util.List;

@Controller
@ControllerAdvice
public class HomeController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookCardService bookCardService;

    @GetMapping("")
    public String getHome() {
        return "home";
    }

    @GetMapping("/listBook")
    public String getListBook(ModelMap modelMap) {
        List<Book> bookList = bookService.getListBook();
        modelMap.addAttribute("list", bookList);
        return "borrow_book";
    }

    @PostMapping("/borrowBook/{id}")
    public String borrowBook(ModelMap modelMap, @PathVariable Integer id) throws OutOfBooks {
        if (bookService.getBookById(id) != null) {
            Book book = bookService.getBookById(id);
            book.decrementRemain();
            bookService.saveBook(book);
            BookCard bookCard = new BookCard();
            bookCard.setCode((int) ((Math.random() * (99999 - 10000)) + 10000));
            bookCard.setBook(book);
            bookCardService.saveBookCard(bookCard);
            modelMap.addAttribute("code", bookCard.getCode());
            return "code_return_book";
        }
        return null;
    }

    @PostMapping("/returnBook")
    public String returnBook(ModelMap modelMap, @Valid @ModelAttribute("bookCard") BookCard bookCard, BindingResult result) throws CodeNotFound {
        if (result.hasErrors()) {
            return "book_card_invalid";
        }
        Book book = bookCardService.findByCode(bookCard.getCode()).getBook();
        book.incrementRemain();
        bookService.saveBook(book);
        bookCardService.deleteByCode(bookCard.getCode());
        return "return_book_success";
    }

    @GetMapping("/returnBook")
    public String getPageReturnBook(ModelMap modelMap) {
        modelMap.addAttribute("bookCard", new BookCard());
        return "return_book";
    }

    @ExceptionHandler(OutOfBooks.class)
    public ModelAndView handleException(OutOfBooks ex) {
        //Do something additional if required
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("message", ex.getMessage());
        return modelAndView;
    }

    @ExceptionHandler(CodeNotFound.class)
    public ModelAndView handleException(CodeNotFound ex) {
        //Do something additional if required
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("message", ex.getMessage());
        return modelAndView;
    }
}
