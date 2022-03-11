package com.example.blogpost2.services;

import com.example.blogpost2.models.BlogPost;
import com.example.blogpost2.models.Comment;
import com.example.blogpost2.repositories.BlogPostRepository;
import com.example.blogpost2.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BlogPostService implements CrudService<BlogPost, Long> {

    @Autowired
    BlogPostRepository blogPostRepository;

    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<BlogPost> findAll() {
        return blogPostRepository.findAll();
    }

    @Override
    public BlogPost findById(Long id) {
        return blogPostRepository.findById(id).orElse(null);
    }

    @Override
    public BlogPost save(BlogPost object) {
        return blogPostRepository.save(object);
    }

    @Override
    public void delete(BlogPost object) {

    }

    @Override
    public void deleteById(Long id) {
        blogPostRepository.deleteById(id);
    }

    @Override
    public Page<BlogPost> findAllByPage(Pageable pageable) {
        return null;
    }

    public ResponseEntity<Set<Comment>> getAllComments(Long postId) {
        Optional <BlogPost> blogPost = blogPostRepository.findById(postId);
        if (blogPost.isPresent()){
             return ResponseEntity.ok(blogPost.get().getComments());
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Integer> getCommentSize(Long postId) {
        Optional <BlogPost> blogPost = blogPostRepository.findById(postId);
        if (blogPost.isPresent()){
             return ResponseEntity.ok(blogPost.get().getComments().size());
        }
        return ResponseEntity.notFound().build();
    }



//    public ResponseEntity<BlogPost> saveComment(Long commentId, Long id) {
//        Optional <BlogPost> blogPost = blogPostRepository.findById(id);
//        if (blogPost.isPresent()){
//            Optional <Comment> comment = commentRepository.findById(commentId);
//            if (comment.isPresent()){
//                blogPost.get().getComments().add(comment.get());
//                return ResponseEntity.ok(blogPostRepository.save(blogPost.get()));
//            }
//        }
//        return ResponseEntity.badRequest().build();
//    }

    public void deleteComment(Comment comment) {
        commentRepository.delete(comment);
    }

    public Comment getCommentById(Long id) {
        return commentRepository.getById(id);
    }
}
