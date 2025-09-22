package model;

import lombok.Data;

import java.util.List;

@Data
public class Orders {
    private Long id;
    private List<Long> bookIds;

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
