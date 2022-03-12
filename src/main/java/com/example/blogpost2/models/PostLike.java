package com.example.blogpost2.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    @ManyToOne
    @JsonBackReference
    private BlogPost blogPost;

    private Timestamp createdAt;
}
