package org.library.orders.service;

import org.library.orders.client.BookClient;
import org.library.orders.eventdriven.OrderEventPublisher;
import org.library.orders.model.Orders;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final List<Orders> orders = new ArrayList<>();
    private final BookClient bookClient;
    private final OrderEventPublisher orderEventPublisher;

    public OrderService(final BookClient bookClient, OrderEventPublisher orderEventPublisher) {
        this.bookClient = bookClient;
        this.orderEventPublisher = orderEventPublisher;
    }

    public List<Orders> getAllOrders() {
        return orders;
    }

    public void createOrder(Orders order) {
        // Check and decrease stock for each book
        for (Long bookId : order.getBookIds()) {
            boolean success = bookClient.decreaseStock(bookId);
            if (!success) {
                throw new RuntimeException("Book with ID " + bookId + " is out of stock.");
            }
        }

        orders.add(order);
        orderEventPublisher.publishOrderPlacedEvent(order);
    }

}
