package com.carol.jpa02.repository;

import com.carol.jpa02.model.Board;
import com.carol.jpa02.model.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {

}
