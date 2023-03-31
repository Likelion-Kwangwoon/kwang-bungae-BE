package com.kwang.kwangThunder.Controller;

import com.kwang.kwangThunder.DTO.CommentCreateDTO;
import com.kwang.kwangThunder.DTO.CommentListDTO;
import com.kwang.kwangThunder.DTO.MyPageCommentDTO;
import com.kwang.kwangThunder.Entity.Comment;
import com.kwang.kwangThunder.Entity.Member;
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
    public CommentCreateDTO createComment(@RequestBody CommentCreateDTO dto) {
        Comment comment = Comment.builder().content(dto.getContent()).build(); // builder 사용 시 필요한 요소만 설정 가능
        Comment newComment = commentService.createComment(comment,dto.getPostId(), dto.getMemberId());
        CommentCreateDTO newDto = new CommentCreateDTO(dto.getPostId(), dto.getMemberId(), comment.getContent());
        return newDto;
        // 그럼 여기서 postId도 설정
    }

    @GetMapping("/list")
    public List<CommentListDTO> readAllComment(@RequestParam Long postId) {
        List<Comment> commentList = commentService.findAllComment(postId);
        List<CommentListDTO> dtoList = new ArrayList<CommentListDTO>();
        for (Comment comment : commentList) {
            Member member = comment.getMember();
            dtoList.add(new CommentListDTO(postId, member.getMemberId(), comment.getContent(), comment.getCommentId()));
        }
        return dtoList;
    }

    // 마이페이지 댓글 목록
    @GetMapping("/list/member")
    public List<MyPageCommentDTO> readCommentByMemberId(@RequestParam Long memberId) {
        List<Comment> commentList = commentService.findCommentByMemberId(memberId);
        List<MyPageCommentDTO> dtoList = new ArrayList<MyPageCommentDTO>();
        for (Comment comment : commentList) {
            dtoList.add(new MyPageCommentDTO(comment.getContent()));
        }
        return dtoList;
    }

    @DeleteMapping("/") // 여기서 commentId 도 받아와야 하는데 CommentRequestDTO에 없음.. 분리 필요 -> CommentCreateDTO, CommentListDTO 분리했음
    public void deleteComment(@RequestParam Long commentId) {
        commentService.deleteComment(commentId);
    }
}
