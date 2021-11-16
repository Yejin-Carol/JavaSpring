package com.kakao.hellospring;

import com.kakao.hellospring.aop.TimeTraceAop;
import com.kakao.hellospring.repository.MemberRepository;
import com.kakao.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);

    }

    @Bean
    public TimeTraceAop TimeTraceAop() {
        return new TimeTraceAop();
    }


 //   @Bean
 //   public MemberRepository memberRepository() {

        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        //return new JpaMemberRepository(em);
 //   }
}
