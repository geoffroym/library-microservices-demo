package org.library.book.model;

import lombok.Data;

import java.util.List;

@Data
public class Orders {
    private Long id;
    private List<Long> bookIds;

}
