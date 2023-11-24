package kz.miras.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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


}
