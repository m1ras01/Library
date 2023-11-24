package kz.miras.spring.controllers;

import kz.miras.spring.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import kz.miras.spring.dao.bookDAO;
import kz.miras.spring.dao.authorDAO;

@Controller
@RequestMapping("/books")
public class BookController {
    private final bookDAO bookDAO;
    private final authorDAO authorDAO;

    @Autowired
    public BookController(bookDAO bookDAO,authorDAO authorDAO) {
        this.authorDAO = authorDAO;
        this.bookDAO = bookDAO;
    }

    @GetMapping()
    public String index(Model model) throws Exception{
        model.addAttribute("books", bookDAO.index());
        return "book/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("book",bookDAO.show(id));
        return "book/show";
    }

    @GetMapping("/new")
    public String newBook(Model model){
        model.addAttribute("books",new Book());
        return "books/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("books") Book book){
        bookDAO.save(book);
        return "redirect:/books";
    }
}
