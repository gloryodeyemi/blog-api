package com.example.blogpost2.services;

import com.example.blogpost2.models.PostLike;
import com.example.blogpost2.repositories.PostLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostLikeService implements CrudService<PostLike, Long> {

    @Autowired
    PostLikeRepository postLikeRepository;

    @Override
    public List<PostLike> findAll() {
        return postLikeRepository.findAll();
    }

    @Override
    public PostLike findById(Long aLong) {
        return postLikeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PostLike save(PostLike object) {
        return postLikeRepository.save(object);
    }

    @Override
    public void delete(PostLike object) {

    }

    @Override
    public void deleteById(Long aLong) {
        postLikeRepository.deleteById(aLong);
    }

    @Override
    public Page<PostLike> findAllByPage(Pageable pageable) {
        return null;
    }
}
