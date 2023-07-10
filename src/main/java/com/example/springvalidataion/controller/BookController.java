package com.example.springvalidataion.controller;

import com.example.springvalidataion.ds.Author;
import com.example.springvalidataion.ds.Books;
import com.example.springvalidataion.service.AuthorService;
import com.example.springvalidataion.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;

    @GetMapping("/books")
    public String create(Model model){
        model.addAttribute("books",new Books());
        model.addAttribute("authors",authorService.findAllAuthors());
        return "bookForm";
    }
    @PostMapping("/books")
    public String process(@Valid Books books, BindingResult result){
        if(result.hasErrors()){
            return "bookForm";
        }
        Author author=authorService.findAuthor(books.getAuthor().getId());
        books.setAuthor(author);
         bookService.save(books);
         return "redirect:/books/all";
    }

    @GetMapping("/books/all")
    public String allBooks(Model model){
        model.addAttribute("books",bookService.findAllBooks());
        return "allBooks";
    }

}