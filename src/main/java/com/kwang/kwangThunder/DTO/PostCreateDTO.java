package com.kwang.kwangThunder.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PostCreateDTO { // 게시물 작성 시 사용하는 DTO
    private Long memberId;
    private String title;
    private Integer people;
    private String link;
    private String content;
}
