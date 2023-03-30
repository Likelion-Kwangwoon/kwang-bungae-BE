package com.kwang.kwangThunder.Controller;


import com.kwang.kwangThunder.DTO.MyPagePostDTO;
import com.kwang.kwangThunder.DTO.PostCreateDTO;
import com.kwang.kwangThunder.Entity.Post;
import com.kwang.kwangThunder.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/create")
    public Post createPost(@RequestBody PostCreateDTO dto) {
        Post post = Post.builder().title(dto.getTitle())
                .people(dto.getPeople())
                .link(dto.getLink())
                .content(dto.getContent())
                .build(); // builder 이용하면 필요한 속성값만 넣어줄 수 있음 !
        Post newPost = postService.createPost(post, dto.getMemberId());
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

    @DeleteMapping("/") // 지우는 메소드 앞에 쓰는 어노테이션
    public void deletePost(@RequestParam Long postId) {
        postService.deletePost(postId);
    }

    // 마이페이지 작성글 목록
    @GetMapping("/list/member")
    public List<MyPagePostDTO> readPostByMemberId(@RequestParam Long memberId) {
        List<Post> postList = postService.findPostByMemberId(memberId);
        List<MyPagePostDTO> dtoList = new ArrayList<MyPagePostDTO>();
        for (Post post : postList) {
            dtoList.add(new MyPagePostDTO(post.getTitle()));
        }
        return dtoList;
    }
}
