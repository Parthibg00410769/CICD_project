package com.example.CICD1.respository;

import com.example.CICD1.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PostRepository extends MongoRepository<Post, String> {
}
