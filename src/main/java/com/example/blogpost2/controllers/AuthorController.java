package com.example.blogpost2.controllers;

import com.example.blogpost2.dtos.AuthorDto;
import com.example.blogpost2.dtos.BlogPostDTO;
import com.example.blogpost2.models.Author;
import com.example.blogpost2.models.BlogPost;
import com.example.blogpost2.services.AuthorService;
import com.example.blogpost2.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("author")
public class AuthorController {

    List<Author> authorList = new ArrayList<>();

    @Autowired
    AuthorService authorService;

    @PostMapping
    public ResponseEntity<Author> createAuthor (@RequestBody AuthorDto authorDto){
        Author author = new Author();
        author.setFirstName(authorDto.getFirstName());
        author.setLastName(authorDto.getLastName());
        return ResponseEntity.ok(authorService.save(author));
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthor() {
        return ResponseEntity.ok(authorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        Author author = authorService.findById(id);
        if (author == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(author);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Author> updateBlogPost(@PathVariable Long id, @RequestBody AuthorDto update) {
        Author author = new Author();
        author.setFirstName(update.getFirstName());
        author.setLastName(update.getLastName());
        author.setId(id);
        return ResponseEntity.ok(authorService.save(author));
    }

    @DeleteMapping("/{id}")
    public void deleteOneAuthor(@PathVariable Long id) {
        authorService.deleteById(id);
    }
}
