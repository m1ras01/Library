package kz.miras.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import kz.miras.spring.dao.bookDAO;

@Controller
@RequestMapping("/books")
public class BookController {
    private final bookDAO bookDAO;

    @Autowired
    public BookController(kz.miras.spring.dao.bookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @GetMapping()
    public String index(Model model) throws Exception{
        model.addAttribute("kytap", bookDAO.index());
        return "book/index";
    }
}
