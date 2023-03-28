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

    public Post createPost(Post post, Long memberId) {
        Member member = memberRepository.findById(memberId).get();
        post.setMember(member);
        return postRepository.save(post);
    }

    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    public Post findPost(Long postId) {
        Post post = postRepository.findById(postId).get();
        return post;
    }

    // 특정 회원이 작성한 글 목록
    public List<Post> findPostByMemberId(Long memberId) {
        Member member = memberRepository.findById(memberId).get();
        return postRepository.findByMember(member);
    }

    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId).get();
        postRepository.delete(post);
    }
}
