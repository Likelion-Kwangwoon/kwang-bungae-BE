package com.kwang.kwangThunder.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CommentCreateDTO { // 댓글 작성 시 사용하는 DTO

    private Long postId;
    private String content;
}
