package org.library.orders.controller;


import org.library.orders.client.BookClient;
import org.library.orders.model.Orders;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrderController {

    private final BookClient bookClient;
    private final List<Orders> orders = new ArrayList<>();

    public OrderController(BookClient bookClient) {
        this.bookClient = bookClient;
    }

    @PostMapping
    public String createOrder(@RequestBody Orders order) {
        orders.add(order);

        StringBuilder books = new StringBuilder();
        for (Long id : order.getBookIds()) {
            books.append(bookClient.getBookById(id)).append(", ");
        }
        return "Order created for: " + books;
    }

    @GetMapping
    public List<Orders> getAllOrders() {
        return orders;
    }

}