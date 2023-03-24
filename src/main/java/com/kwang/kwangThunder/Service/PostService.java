package com.kwang.kwangThunder.Service;

import com.kwang.kwangThunder.Entity.Post;
import com.kwang.kwangThunder.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post createPost(Post post) { // 테이블에 저장
        return postRepository.save(post);
    }

    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    public Post findPost(Long postId) {
        Post post = postRepository.findById(postId).get();
        return post;
    }

    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId).get();
        postRepository.delete(post);
    }
}
