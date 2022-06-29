package com.javacourse.SpringMongo.services;


import com.javacourse.SpringMongo.domain.Post;
import com.javacourse.SpringMongo.repository.PostRepository;
import com.javacourse.SpringMongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return postRepository.fullSearch(text,minDate,maxDate);
    }
}
