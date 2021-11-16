package com.kakao.hellospring.repository;

import com.kakao.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
//Spring Jpa가 인터페이스 구현체를 자체 기술로 만들어내고 Spring Bean에 등록함
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
}
