package com.kwang.kwangThunder.Controller;


import com.kwang.kwangThunder.Entity.Post;
import com.kwang.kwangThunder.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/create")
    public Post createPost(@RequestBody Post post) {
        Post newPost = postService.createPost(post);
        return newPost;
    }

    @GetMapping("/list")
    public List<Post> readAllPost() {
        List<Post> postList = postService.findAllPosts();
        return postList;
    }

    @GetMapping("/detail")
    public Post readPost(@RequestParam Long postId) {
        Post post = postService.findPost(postId);
        return post;
    }

    //GET POST DELETE PUT PATCH
    @DeleteMapping("/") // 지우는 메소드 앞에 쓰는 어노테이션
    public void deletePost(@RequestParam Long postId) {
        postService.deletePost(postId);
    }
}
