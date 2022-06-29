package com.javacourse.SpringMongo.services;


import com.javacourse.SpringMongo.domain.Post;
import com.javacourse.SpringMongo.repository.PostRepository;
import com.javacourse.SpringMongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id){
        Post post = postRepository.findById(id).orElse(null);
        if (post == null){
            throw new ObjectNotFoundException("Object not found");
        }
        return post;
    }

    public List<Post> findByTitle(String text){
        return postRepository.findByTitle(text);
    }
}
