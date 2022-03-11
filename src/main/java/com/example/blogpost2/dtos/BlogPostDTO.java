package com.example.blogpost2.dtos;

import com.example.blogpost2.models.Comment;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class BlogPostDTO {
    private Long id;
    private String title;
    private String content;
    private Long author;


}
