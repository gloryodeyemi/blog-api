package com.example.blogpost2.controllers;

import com.example.blogpost2.dtos.BlogPostDTO;
import com.example.blogpost2.dtos.CommentDto;
import com.example.blogpost2.models.Author;
import com.example.blogpost2.models.BlogPost;
import com.example.blogpost2.models.Comment;
import com.example.blogpost2.services.AuthorService;
import com.example.blogpost2.services.BlogPostService;
import com.example.blogpost2.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("comments")
public class CommentController {

    List<Comment> commentList = new ArrayList<>();

    @Autowired
    CommentService commentService;

    @Autowired
    AuthorService authorService;

    @Autowired
    BlogPostService blogPostService;

    @PostMapping
    public ResponseEntity<Comment> createComment (@RequestBody CommentDto commentDto ){
//            , @PathVariable() Long blogPostId){
        Comment comment =  new Comment();
//        Comment comment = commentService.save(commentDto, blogPostId);

        comment.setMessage(commentDto.getMessage());
        Author author = authorService.findById(commentDto.getAuthor());
        if (author == null){
            return ResponseEntity.notFound().build();
        }
        comment.setAuthor(author);
        BlogPost blogPost = blogPostService.findById(commentDto.getBlogPost());
        if (blogPost == null) {
            return ResponseEntity.notFound().build();
        }
        comment.setBlogPost(blogPost);

        return ResponseEntity.ok(commentService.save(comment));
    }

    @GetMapping
    public ResponseEntity<List<Comment>> getAllComments() {
        return ResponseEntity.ok(commentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getComment(@PathVariable Long id) {
        Comment comment = commentService.findById(id);
        if (comment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(comment);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestBody CommentDto update) {
        Comment comment =  new Comment();

        comment.setMessage(update.getMessage());
        Author author = authorService.findById(update.getAuthor());
        if (author == null){
            return ResponseEntity.badRequest().build();
        }
        comment.setAuthor(author);
        comment.setId(id);
        return ResponseEntity.ok(commentService.save(comment));
    }

    @DeleteMapping("/{id}")
    public void deleteOneComment(@PathVariable Long id) {
        commentService.deleteById(id);
    }
}
