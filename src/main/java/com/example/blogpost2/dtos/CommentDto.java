package com.example.blogpost2.dtos;

import com.example.blogpost2.models.Author;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToOne;

@Getter @Setter
public class CommentDto {
    private Long id;
    private String message;
    private Long author;
    private Long blogPost;
}
