package com.Thispage.Thispage.Service;

import com.Thispage.Thispage.DTO.PostDTO;
import com.Thispage.Thispage.Domain.Post;
import com.Thispage.Thispage.Mapper.PostMapper;
import com.Thispage.Thispage.Repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public PostService(PostRepository postRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    public PostDTO createPost(PostDTO post) {
        if(post.creator() == null) {
            throw new IllegalArgumentException("Post must have a creator.");
        }
        Post postEntity = postMapper.toEntity(post);
        postRepository.save(postEntity);
        return postMapper.toDTO(postEntity);
    }

    public List<PostDTO> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(postMapper::toDTO)
                .toList();
    }

    public PostDTO getPostById(UUID id) {
        return postMapper.toDTO(postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Post not found with id: " + id)));
    }

    public PostDTO updatePost(UUID id, PostDTO post) {
        Post existingPost = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Post not found with id: " + id));

        if(post.creator() != existingPost.getCreator() || post.creator() == null) {
            throw new IllegalArgumentException("Post must have a creator and it must match the existing post's creator.");
        }

        existingPost.setTitle(post.title());
        existingPost.setContent(post.content());

        postRepository.save(existingPost);
        return postMapper.toDTO(existingPost);
    }

    public void deletePost(UUID id) {
        postRepository.deleteById(id);
    }
}
