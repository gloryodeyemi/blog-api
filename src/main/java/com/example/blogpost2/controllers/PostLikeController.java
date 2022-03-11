package com.example.blogpost2.controllers;

import com.example.blogpost2.dtos.PostLikeDto;
import com.example.blogpost2.models.Author;
import com.example.blogpost2.models.PostLike;
import com.example.blogpost2.services.AuthorService;
import com.example.blogpost2.services.PostLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("post-like")
public class PostLikeController {
    List<PostLike> postLikeList = new ArrayList<>();

    @Autowired
    PostLikeService postLikeService;

    @Autowired
    AuthorService authorService;

    @PostMapping
    public ResponseEntity<PostLike> createLike (@RequestBody PostLikeDto postLikeDto){
        PostLike postLike =  new PostLike();

        Author author = authorService.findById(postLikeDto.getAuthor());
        if (author == null){
            return ResponseEntity.badRequest().build();
        }
        postLike.setAuthor(author);
        return ResponseEntity.ok(postLikeService.save(postLike));
    }

    @GetMapping
    public ResponseEntity<List<PostLike>> getAllPostLikes() {
        return ResponseEntity.ok(postLikeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostLike> getLikeById(@PathVariable Long id) {
        PostLike postLike = postLikeService.findById(id);
        if (postLike == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(postLike);
    }

    @DeleteMapping("/{id}")
    public void deleteOneLike(@PathVariable Long id) {
        postLikeService.deleteById(id);
    }
}
