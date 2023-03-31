package com.kwang.kwangThunder.Controller;

import com.kwang.kwangThunder.DTO.CommentCreateDTO;
import com.kwang.kwangThunder.DTO.CommentListDTO;
import com.kwang.kwangThunder.DTO.MyPageCommentDTO;
import com.kwang.kwangThunder.Entity.Comment;
import com.kwang.kwangThunder.Entity.Member;
import com.kwang.kwangThunder.Service.CommentService;
import com.kwang.kwangThunder.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/create")
    public Member createComment(@RequestBody  Member member)
    {
        return memberService.createMember(member);
    }

}
