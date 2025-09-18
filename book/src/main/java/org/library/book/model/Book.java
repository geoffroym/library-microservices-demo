package org.library.book.model;

public class Book {
    private Long id;
    private String title;
    private String author;
    int stockQuantity;
    BookCategory category;
    private double price;

    public Book(Long id, String title, String author, int stockQuantity, BookCategory category, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.stockQuantity = stockQuantity;
        this.category = category;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public BookCategory getCategory() {
        return category;
    }

    public void setCategory(BookCategory category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}




