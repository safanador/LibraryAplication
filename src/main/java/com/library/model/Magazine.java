package com.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "magazine")
@EqualsAndHashCode(callSuper = true)
public class Magazine extends LibraryItem {
    private String category;
    private Integer issueNumber;
    private String publisher;
}