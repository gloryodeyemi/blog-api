package com.example.blogpost2.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "blogpost")
public class BlogPost {

    @Id
    @GeneratedValue
    @Column(name = "blogpost_id")
    private Long id;
    private String title;
    private String content;

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    @ManyToOne
    private Author author;

    @OneToMany(mappedBy = "blogPost", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Comment> comments;

//    private int commentCount = 0;

//    @OneToMany
//    private Set<Like> likes;
}
