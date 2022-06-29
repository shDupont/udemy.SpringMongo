package com.javacourse.SpringMongo.repository;

import com.javacourse.SpringMongo.domain.Post;
import com.javacourse.SpringMongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
