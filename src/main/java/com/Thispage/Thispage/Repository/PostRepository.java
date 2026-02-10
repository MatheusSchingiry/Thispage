package com.Thispage.Thispage.Repository;

import com.Thispage.Thispage.Domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
