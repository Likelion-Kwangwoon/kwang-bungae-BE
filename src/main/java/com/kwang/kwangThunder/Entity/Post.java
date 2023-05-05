package com.kwang.kwangThunder.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    private String content;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public void setMember(Member member) {
        this.member = member;
    }


    //분야코드
    //마감여부코드
    //작성일시

}
