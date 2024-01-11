package com.example.CICD1.respository;

import java.util.List;

import com.example.CICD1.model.Post;

public interface SearchRespository {

    List<Post> findByText(String text);
}