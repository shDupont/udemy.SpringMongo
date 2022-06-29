package com.javacourse.SpringMongo.repository;

import com.javacourse.SpringMongo.domain.Post;
import com.javacourse.SpringMongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByTitleContainingIgnoreCase(String text);
}
