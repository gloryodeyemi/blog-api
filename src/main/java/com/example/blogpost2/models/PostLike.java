package com.example.blogpost2.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

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
//    @JsonManagedReference
    private BlogPost blogPost;

    @CreationTimestamp
    private Timestamp createdAt;
}
