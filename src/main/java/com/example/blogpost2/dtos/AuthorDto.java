package com.example.blogpost2.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AuthorDto {
    private Long id;
    private String firstName;
    private String lastName;
}
