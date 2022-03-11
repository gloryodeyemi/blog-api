package com.example.blogpost2.services;

import com.example.blogpost2.models.Author;
import com.example.blogpost2.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService implements CrudService<Author, Long> {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public Author save(Author object) {
        return authorRepository.save(object);
    }

    @Override
    public void delete(Author object) {

    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Page<Author> findAllByPage(Pageable pageable) {
        return null;
    }
}
