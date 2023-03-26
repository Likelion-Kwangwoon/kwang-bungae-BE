package com.kwang.kwangThunder.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @OneToMany(mappedBy = "post") // Comment의 Post 객체 이름
    private List<Comment> comments = new ArrayList<>();

    public void addComment(Comment comment) {
        this.comments.add(comment);
        if (comment.getPost() != this) {
            comment.setPost(this);
        }
    }

    //private LocalDateTime dday;

    private String content; //길이제한 세팅
    //회원코드
    //분야코드
    //마감여부코드




}
