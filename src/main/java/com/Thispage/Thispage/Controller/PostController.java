package com.Thispage.Thispage.Controller;

import com.Thispage.Thispage.DTO.PostDTO;
import com.Thispage.Thispage.Domain.Post;
import com.Thispage.Thispage.Service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public PostDTO createPost(@RequestBody PostDTO post) {
        return postService.createPost(post);
    }

    @GetMapping()
    public List<PostDTO> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public PostDTO findById(@PathVariable UUID id) {
        return postService.getPostById(id);
    }

    @PutMapping("/{id}")
    public PostDTO updatePost(@PathVariable UUID id, @RequestBody PostDTO post) {
        return postService.updatePost(id, post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable UUID id) {
        postService.deletePost(id);
    }
}
