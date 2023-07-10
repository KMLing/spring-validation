package com.example.springvalidataion.service;

import com.example.springvalidataion.ds.Books;
import org.springframework.stereotype.Service;

import java.util.List;
public interface BookService {

    Books save(Books books);
    Books findById(Integer id);
    List<Books> findAllBooks();
    List<Books> findBooksByAuthorName(String name);

}
