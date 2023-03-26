package com.kwang.kwangThunder.Service;

import com.kwang.kwangThunder.Entity.Comment;
import com.kwang.kwangThunder.Entity.Post;
import com.kwang.kwangThunder.Repository.CommentRepository;
import com.kwang.kwangThunder.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;

    public Comment createComment(Comment comment, Long postId)
    {
        Post post = postRepository.findById(postId).get(); // get 찾아보기
        comment.setPost(post);
        return commentRepository.save(comment);
    }

    public List<Comment> findAllComment(Long postId) {

        Post post = postRepository.findById(postId).get();
        return commentRepository.findByPost(post);
    }

    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).get();
        commentRepository.delete(comment);
    }
}
