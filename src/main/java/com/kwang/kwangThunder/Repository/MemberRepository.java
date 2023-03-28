package com.kwang.kwangThunder.Repository;

import com.kwang.kwangThunder.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
