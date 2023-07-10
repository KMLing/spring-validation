package com.example.springvalidataion.service;

import com.example.springvalidataion.dao.BooksRepository;
import com.example.springvalidataion.ds.Books;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class BookServiceImpl implements BookService{

    private final BooksRepository booksRepository;

    public BookServiceImpl(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public Books save(Books books) {
        return booksRepository.save(books);
    }

    @Override
    public Books findById(Integer id) {
        return booksRepository.getOne(id);
    }

    @Override
    public List<Books> findAllBooks() {
        return booksRepository.findAll();
    }

    @Override
    public List<Books> findBooksByAuthorName(String name) {
        return booksRepository.findBooksByAuthorName(name);
    }
}
