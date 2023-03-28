package com.kwang.kwangThunder.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CommentListDTO { // 댓글 목록 불러올 때 사용하는 DTO

    private Long postId;
    private String content;
    private Long commentId;
}
