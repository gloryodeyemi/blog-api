package com.example.blogpost2.dtos;

import com.example.blogpost2.models.Author;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.OneToOne;

@Getter @Setter
public class PostLikeDto {
    private Long id;
    private Long author;
    private Long blogPost;
}
