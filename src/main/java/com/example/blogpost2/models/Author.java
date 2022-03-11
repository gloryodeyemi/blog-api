package com.example.blogpost2.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;

}
