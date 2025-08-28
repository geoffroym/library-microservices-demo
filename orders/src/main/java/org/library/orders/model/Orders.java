package org.library.orders.model;

import java.util.List;

public class Orders {
    private Long id;
    private List<Long> bookIds;

    public Orders(Long id, List<Long> bookIds) {
        this.id = id;
        this.bookIds = bookIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getBookIds() {
        return bookIds;
    }

    public void setBookIds(List<Long> bookIds) {
        this.bookIds = bookIds;
    }
}
