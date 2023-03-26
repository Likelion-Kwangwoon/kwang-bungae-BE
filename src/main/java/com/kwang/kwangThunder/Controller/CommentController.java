package com.kwang.kwangThunder.Controller;

import com.kwang.kwangThunder.DTO.CommentRequestDTO;
import com.kwang.kwangThunder.Entity.Comment;
import com.kwang.kwangThunder.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/create")
    public CommentRequestDTO createComment(@RequestBody CommentRequestDTO dto) {

        Comment comment = Comment.builder().content(dto.getContent()).build();
        Comment newComment = commentService.createComment(comment,dto.getPostId());
        CommentRequestDTO newDto = new CommentRequestDTO(dto.getPostId(), comment.getContent());
        return newDto;
        // 그럼 여기서 postId도 설정
    }

    @GetMapping("/list")
    public List<CommentRequestDTO> readAllComment(Long postId) {
        List<Comment> commentList = commentService.findAllComment(postId);
        List<CommentRequestDTO> dtoList = new ArrayList<CommentRequestDTO>();
        for (Comment comment : commentList) {
            dtoList.add(new CommentRequestDTO(postId ,comment.getContent()));
        }
        return dtoList;
    }

    @DeleteMapping("/")
    public void deleteComment(@RequestBody Long commentId) {
        commentService.deleteComment(commentId);
    }
}
