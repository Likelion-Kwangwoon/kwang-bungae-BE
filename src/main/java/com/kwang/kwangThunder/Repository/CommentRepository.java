package com.kwang.kwangThunder.Repository;

import com.kwang.kwangThunder.Entity.Comment;
import com.kwang.kwangThunder.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    public List<Comment> findByPost(Post post);
}
