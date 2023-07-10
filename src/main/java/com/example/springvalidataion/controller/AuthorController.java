package com.example.springvalidataion.controller;


import com.example.springvalidataion.ds.Author;
import com.example.springvalidataion.service.AuthorService;
import com.example.springvalidataion.validators.AuthorValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class AuthorController {

    private final AuthorService authorService;
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @GetMapping("/author")
    public String authorForm(Model model){
        model.addAttribute("author",new Author());
        return "authorForm";
    }
    @PostMapping("/author")
    public String processAuthor(@Valid  Author author, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "authorForm";
        }
        authorService.save(author);
        redirectAttributes.addFlashAttribute("success",true);
        return "redirect:/author/all";
    }
    @GetMapping("author/all")
    public String showAllAuthors(Model model){
        model.addAttribute("authors",authorService.findAllAuthors());
        model.addAttribute("success",model.containsAttribute("success"));
        return "authors";
    }

    @InitBinder
    protected  void initBinder(WebDataBinder binder){
        binder.setValidator(new AuthorValidator());
    }




}
