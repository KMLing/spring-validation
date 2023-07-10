package com.example.springvalidataion.service;

import com.example.springvalidataion.ds.Author;

import java.util.List;

public interface AuthorService {
    Author save(Author author);
    Author findAuthor(int id);
    List<Author> findAllAuthors();
}
