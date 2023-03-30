package com.kwang.kwangThunder.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MyPageCommentDTO { // 마이페이지 글 목록 DTO
   private String content;
}
