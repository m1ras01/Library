package kz.miras.spring.controllers;

import jakarta.validation.Valid;
import kz.miras.spring.models.Author;
import kz.miras.spring.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import kz.miras.spring.dao.authorDAO;

import java.sql.SQLException;

@Controller
@RequestMapping("/people")
public class AuthorController {

    private final authorDAO authorDAO;

    @Autowired
    public AuthorController(authorDAO authorDAO){
        this.authorDAO = authorDAO;
    }

    @GetMapping()
    public String index(Model model) throws SQLException {
        model.addAttribute("person", authorDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id , Model model){
        model.addAttribute("person",authorDAO.show(id));
        return "people/show";
    }
    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("person",new Author());
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") /*@Valid*/ Author author, BindingResult bindingResult){
//        if (bindingResult.hasErrors()){
//            return "people/new";
//        }
        authorDAO.save(author);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model,@PathVariable("id") int id){
        model.addAttribute("person",authorDAO.show(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Author author, BindingResult bindingResult, @PathVariable("id") int id){
        if (bindingResult.hasErrors()){
            return "people/edit";
        }
        authorDAO.update(id,author);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        authorDAO.delete(id);
        return "redirect:/people";
    }
}