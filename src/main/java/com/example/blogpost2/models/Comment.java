package com.example.blogpost2.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    private String message;

    @ManyToOne
    private Author author;

    @ManyToOne
//    @JoinColumn(name = "blogpost_id", referencedColumnName = "blogpost_id", nullable = false)
    private BlogPost blogPost;

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

}
