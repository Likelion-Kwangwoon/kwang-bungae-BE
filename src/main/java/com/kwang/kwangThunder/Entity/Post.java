package com.kwang.kwangThunder.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity // Table 생성
@Data // getter setter 함수 안 만들어도 됨 !!
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id //PK
    @GeneratedValue
    @Column(name= "post_id") // 컬럼 이름 지정
    private Long postId;
    private String title;
    private Integer people;
    private String link;

    //private LocalDateTime dday;

    private String content; //길이제한 세팅
    //회원코드
    //분야코드
    //마감여부코드




}
