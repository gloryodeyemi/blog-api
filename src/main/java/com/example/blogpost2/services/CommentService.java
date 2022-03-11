package com.example.blogpost2.services;

import com.example.blogpost2.models.Comment;
import com.example.blogpost2.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements CrudService<Comment, Long> {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public Comment save(Comment object) {
        return commentRepository.save(object);
    }

    @Override
    public void delete(Comment object) {

    }

    @Override
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Page<Comment> findAllByPage(Pageable pageable) {
        return null;
    }
}
