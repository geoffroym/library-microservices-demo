package org.library.book.service;

import lombok.Getter;
import org.library.book.model.Book;
import org.library.book.model.BookCategory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.library.book.model.BookCategory.*;

@Getter
@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();

    public BookService() {
        books.add(new Book(1L, "Carmilla", "Sheridan Le Fanu", 3, HORROR, 10.99));
        books.add(new Book(2L, "SPQR: A history of Ancient Rome", "Mary Beard", 5, HISTORY, 11.99));
        books.add(new Book(3L, "The Count of Monte Cristo", "Alexandre Dumas", 2, FICTION, 12.99));
        books.add(new Book(4L, "The Darkening Age", "Catherine Nixey", 3, HISTORY, 19.99));
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book getBookById(Long id) {
        return books.stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Book> getBooksByAuthor(String author) {
        return books.stream()
                .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                .toList(); //returns empty list if there is no author with that name
    }

    public List<Book> getBooksByCategory(BookCategory category) {
        return books.stream()
                .filter(b -> b.getCategory().equals(category))
                .toList();
    }

    public List<Book> getBooksByTitle(String title) {
        return books.stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .toList();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean deleteBook(Long id) {
        return books.removeIf(book -> book.getId().equals(id));
    }

    public boolean decreaseStock(Long id) {
        Book book = getBookById(id);
        if (book == null || book.getStockQuantity() <= 0) {
            return false;
        }
        book.setStockQuantity(book.getStockQuantity() - 1);
        return true;
    }

}
