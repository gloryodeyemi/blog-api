package com.example.blogpost2.controllers;

import com.example.blogpost2.dtos.BlogPostDTO;
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
import java.util.Set;

@RestController
@RequestMapping("blogpost")
public class BlogPostController {

    List<BlogPost> blogPostList = new ArrayList<>();

    @Autowired
    BlogPostService blogPostService;

    @Autowired
    AuthorService authorService;

    @Autowired
    CommentService commentService;

    @PostMapping
    public ResponseEntity<BlogPost> createBlogPost (@RequestBody BlogPostDTO blogPostDTO){
        BlogPost blogPost = new BlogPost();

        blogPost.setTitle(blogPostDTO.getTitle());
        blogPost.setContent(blogPostDTO.getContent());
        Author author = authorService.findById(blogPostDTO.getAuthor());
        if (author == null){
            return ResponseEntity.badRequest().build();
        }
        blogPost.setAuthor(author);
        return ResponseEntity.ok(blogPostService.save(blogPost));
    }

    @GetMapping
    public ResponseEntity<List<BlogPost>> getAllBlogPost() {
        return ResponseEntity.ok(blogPostService.findAll());
    }

    @GetMapping("/comment/{id}")
    public ResponseEntity<Set<Comment>> getComments(@PathVariable Long id){
        return blogPostService.getAllComments(id);
    }

    @GetMapping("comment-size/{id}")
    public ResponseEntity<Integer> getCommentSize(@PathVariable Long id){
        return blogPostService.getCommentSize(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogPost> getBlogpostById(@PathVariable Long id) {
        BlogPost blogPost = blogPostService.findById(id);
        if (blogPost == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(blogPost);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BlogPost> updateBlogPost(@PathVariable Long id, @RequestBody BlogPostDTO update) {
        BlogPost blogPost = new BlogPost();

        blogPost.setTitle(update.getTitle());
        blogPost.setContent(update.getContent());
        Author author = authorService.findById(update.getAuthor());
        if (author == null){
            return ResponseEntity.badRequest().build();
        }
        blogPost.setAuthor(author);
        blogPost.setId(id);
        return ResponseEntity.ok(blogPostService.save(blogPost));
    }

    @DeleteMapping("/{id}")
    public void deleteOneBlogPost(@PathVariable Long id) {
        blogPostService.deleteById(id);
    }

//    @PostMapping("/comment")
//    public ResponseEntity<BlogPost> postComment(@RequestBody Long postId, @RequestBody Long commentId){
//        return blogPostService.saveComment(commentId, postId);
//    }
}
