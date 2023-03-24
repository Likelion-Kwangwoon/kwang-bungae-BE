package com.kwang.kwangThunder.Repository;

import com.kwang.kwangThunder.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

//                                             우리가 다루는 테이블 이름, PK 타입 적기
public interface PostRepository extends JpaRepository<Post, Long> {
    // 대박 개꿀팁 Post findByTitleAndPeople(String st,Integer num);


}

