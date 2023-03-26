package com.kwang.kwangThunder.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue
    @Column(name= "comment_id")
    private Long commentId;

    private String content;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public void setPost(Post post) {
        if (this.post != null) {
            this.post.getComments().remove(this);
        }
        this.post = post;
        if (!post.getComments().contains(this)) {
            post.addComment(this); // 코멘트 객체에 post 넣기??
        }
    }

    //private LocalDateTime datetime; 작성일시
    //private String nickname;
    // 사용자 정보도 추가해야 됨


}
