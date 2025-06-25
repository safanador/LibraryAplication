package com.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "dvd")
@EqualsAndHashCode(callSuper = true)
public class DVD extends LibraryItem {
    private String director;
    private String genre;
    private Integer duration; // in minutes
}