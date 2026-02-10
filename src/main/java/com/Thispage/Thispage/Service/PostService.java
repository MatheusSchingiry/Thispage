package com.Thispage.Thispage.Service;

import com.Thispage.Thispage.Domain.Post;
import com.Thispage.Thispage.Repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post createPost(Post post) {
        if(post.getCreator() == null) {
            throw new IllegalArgumentException("Post must have a creator.");
        }
        return postRepository.save(post);
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    public Post updatePost(Long id, Post post) {
        Post existingPost = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Post not found with id: " + id));

        if(post.getCreator() != existingPost.getCreator() || post.getCreator() == null) {
            throw new IllegalArgumentException("Post must have a creator and it must match the existing post's creator.");
        }

        existingPost.setTitle(post.getTitle());
        existingPost.setContent(post.getContent());

        return postRepository.save(existingPost);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
