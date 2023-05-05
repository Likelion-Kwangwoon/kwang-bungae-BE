package com.kwang.kwangThunder.Service;

import com.kwang.kwangThunder.DTO.MyPageCommentDTO;
import com.kwang.kwangThunder.Entity.Comment;
import com.kwang.kwangThunder.Entity.Member;
import com.kwang.kwangThunder.Entity.Post;
import com.kwang.kwangThunder.Repository.CommentRepository;
import com.kwang.kwangThunder.Repository.MemberRepository;
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

    @Autowired
    private MemberRepository memberRepository;

    public Comment createComment(Comment comment, Long postId,  String email)
    {
        Post post = postRepository.findById(postId).get(); // get 찾아보기
        Member member = memberRepository.findByEmail(email).get();
        comment.setPost(post);
        comment.setMember(member);
        return commentRepository.save(comment);
    }

    public List<Comment> findAllComment(Long postId) {

        Post post = postRepository.findById(postId).get();
        return commentRepository.findByPost(post);
    }

    // 특정 회원이 작성한 댓글 목록
    public List<Comment> findCommentByMemberEmail(String email) {
        Member member = memberRepository.findByEmail(email).get();
        return commentRepository.findByMember(member);
    }

    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).get();
        commentRepository.delete(comment);
    }
}
