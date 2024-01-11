package com.example.CICD1.controller;

import com.example.CICD1.model.Post;

import com.example.CICD1.respository.PostRepository;
import com.example.CICD1.respository.SearchRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins =  "*", allowedHeaders = "*")
public class PostController {

    @Autowired
    PostRepository repo;

    @Autowired
    SearchRespository srepo;





    @ApiIgnore
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/allPosts")
    @CrossOrigin
    public List<Post> getAllPosts(){
        return repo.findAll();
    }

    @GetMapping("/posts/{text}")
    @CrossOrigin
    public List<Post> search(@PathVariable String text){
        return srepo.findByText(text);
    }


    @PostMapping("/post")       //jobpost
    @CrossOrigin
    public Post addPost(@RequestBody Post post){        ///whatever data one will submit from the client side will be accepted here
        return repo.save(post);
    }

}

