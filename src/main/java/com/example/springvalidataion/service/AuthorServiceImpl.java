package com.example.springvalidataion.service;


import com.example.springvalidataion.dao.AuthorRepository;
import com.example.springvalidataion.ds.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author findAuthor(int id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }
}
