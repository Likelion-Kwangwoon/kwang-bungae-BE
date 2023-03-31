package com.kwang.kwangThunder.Service;

import com.kwang.kwangThunder.Entity.Member;
import com.kwang.kwangThunder.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService { // 회원 추가만 (탈퇴는 아직)

    @Autowired
    private MemberRepository memberRepository;

    public Member createMember(Member member) { return memberRepository.save(member); }
}
