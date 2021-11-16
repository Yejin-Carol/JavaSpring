package com.kakao.hellospring.repository;

import com.kakao.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);//자바 8, Optional로 감싸서 반환
    Optional<Member> findByName(String name);
    List<Member> findAll();//저장된 모든 것 저장
}
