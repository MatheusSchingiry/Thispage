package com.Thispage.Thispage.Mapper;

import com.Thispage.Thispage.DTO.PostDTO;
import com.Thispage.Thispage.Domain.Post;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostMapper {

    public Post toEntity(PostDTO postDTO) {
        return  new Post(
                postDTO.id(),
                postDTO.title(),
                postDTO.content(),
                postDTO.creator()
        );
    }

    public PostDTO toDTO(Post post) {
        return new PostDTO(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getCreator()
        );
    }
}
