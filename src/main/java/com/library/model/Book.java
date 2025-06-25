package com.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "book")
@EqualsAndHashCode(callSuper = true)
public class Book extends LibraryItem {
    private String author;
    private String isbn;
    private Integer pageCount;
}