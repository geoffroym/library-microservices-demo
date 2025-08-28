package org.library.book.controller;


import org.library.book.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/books")
public class BookController {

    @GetMapping
    public List<Book> getBooks() {
        return Arrays.asList(
                new Book(1L, "Book A", 10.99),
                new Book(2L, "Book B", 12.99),
                new Book(3L, "Book C", 8.99)
        );
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return new Book(id, "Book " + id, 9.99);
    }
}
