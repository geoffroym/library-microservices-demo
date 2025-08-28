package org.library.book.service;

import org.library.book.model.Book;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

import static org.library.book.model.BookCategory.*;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        books.add(new Book(1L, "Book A", "Camila", 3, NON_FICTION,10.99));
        books.add(new Book(2L, "Book B", "Luigi", 5, TECHNOLOGY, 11.99));
        books.add(new Book(3L, "Book C", "Fredrik", 2, SCIENCE, 12.99));
        return books;
    }

    public Book getBookById(Long id) {
        return books.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }
}
