package com.kwang.kwangThunder.Repository;

import com.kwang.kwangThunder.Entity.Comment;
import com.kwang.kwangThunder.Entity.Member;
import com.kwang.kwangThunder.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    public List<Comment> findByPost(Post post);

    // 내가 쓴 댓글
    public List<Comment> findByMember(Member member);

}
