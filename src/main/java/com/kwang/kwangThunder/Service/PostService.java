package com.kwang.kwangThunder.Service;

import com.kwang.kwangThunder.Entity.Member;
import com.kwang.kwangThunder.Entity.Post;
import com.kwang.kwangThunder.Repository.MemberRepository;
import com.kwang.kwangThunder.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private MemberRepository memberRepository;

    // 글 작성
    public Post createPost(Post post, String email) {
        Member member = memberRepository.findByEmail(email).get();
        post.setMember(member);
        return postRepository.save(post);
    }

    // 모든 글 목록
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    // 글 상세보기
    public Post findPost(Long postId) {
        Post post = postRepository.findById(postId).get();
        return post;
    }

    // 특정 회원이 작성한 글 목록
    public List<Post> findPostByEmail(String email) {
        Member member = memberRepository.findByEmail(email).get();
        return postRepository.findByMember(member);
    }

    // 글 삭제
    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId).get();
        postRepository.delete(post);
    }
}
