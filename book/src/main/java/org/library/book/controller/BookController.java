package org.library.book.controller;


import lombok.extern.slf4j.Slf4j;
import org.library.book.model.Book;
import org.library.book.model.BookCategory;
import org.library.book.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/books")
@CrossOrigin(origins = "http://localhost:5173")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable String author) {
        List<Book> books = bookService.getBooksByAuthor(author);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Book>> getBooksByCategory(@PathVariable BookCategory category) {
        List<Book> books = bookService.getBooksByCategory(category);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<Book>> getBooksByTitle(@PathVariable String title) {
        List<Book> books = bookService.getBooksByTitle(title);
        return ResponseEntity.ok(books);
    }

    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return ResponseEntity.ok("Book added");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        boolean deleted = bookService.deleteBook(id);
        if (deleted) {
            return ResponseEntity.noContent().build(); //204 No Content
        } else {
            return ResponseEntity.notFound().build();  //404 Not Found
        }
    }

    @PutMapping("/{id}/decrease-stock")
    public ResponseEntity<Void> decreaseStock(@PathVariable Long id) {
        boolean success = bookService.decreaseStock(id);
        if (success) return ResponseEntity.ok().build();
        else return ResponseEntity.badRequest().build();
    }

}
