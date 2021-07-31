package controller;

import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import services.BookCardService;
import services.BookService;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookCardService bookCardService;

    @GetMapping("")
    public String getHome(){
        return "home";
    }

    @GetMapping("/listBook")
    public String getListBook(ModelMap modelMap){
        List<Book> bookList=bookService.getListBook();
        modelMap.addAttribute("list",bookList);
        return "borrow_book";
    }
}
