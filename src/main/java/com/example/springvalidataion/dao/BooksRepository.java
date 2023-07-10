package com.example.springvalidataion.dao;

import com.example.springvalidataion.ds.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Books,Integer> {

    @Query("select b from Books b where b.name=:name")
    List<Books> findBooksByAuthorName(@Param("name") String name);
}
