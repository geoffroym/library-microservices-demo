package org.library.orders.controller;


import org.library.orders.client.BookClient;
import org.library.orders.model.Orders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/orders")
public class OrderController {

    private final BookClient bookClient;

    public OrderController(BookClient bookClient) {
        this.bookClient = bookClient;
    }

    @PostMapping
    public String createOrder(@RequestBody Orders order) {
        StringBuilder books = new StringBuilder();
        for (Long id : order.getBookIds()) {
            books.append(bookClient.getBookById(id)).append(", ");
        }
        return "Order created for: " + books;
    }
}