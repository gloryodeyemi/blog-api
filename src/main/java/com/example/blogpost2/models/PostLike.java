package com.example.blogpost2.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class PostLike {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Author author;

    private Timestamp createdAt;
}
