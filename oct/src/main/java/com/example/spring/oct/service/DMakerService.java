package com.example.spring.oct.service;

import com.example.spring.oct.entity.Developer;
import com.example.spring.oct.repository.DeveloperRepository;
import com.example.spring.oct.type.DeveloperLevel;
import com.example.spring.oct.type.DeveloperSkillType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


//서비스 레이어, 비즈니스 로직, @Required.. 예전 @Autowired나 @Inject.. 서비스 단독 하는 문제; 그 다음 생성자
//생성자도 repository 여러개면 또 불편하므로 private final 기본 생성자 자동으로 만들어줌.

@Service
@RequiredArgsConstructor
public class DMakerService {
    private final DeveloperRepository developerRepository;

    //ACID(Atomicity, Consistency, Isolation, Durability)
    @Transactional
    public void createDeveloper() {

        //business logic starts
        Developer developer = Developer.builder()
                .developerLevel(DeveloperLevel.JUNIOR)
                .developerSkillType(DeveloperSkillType.FRONT_END)
                .experienceYears(2)
                .name("Olaf")
                .age(5)
                .build();//마지막에 꼭 build해야함. 중간에 하면 중간에 끝남.

        developerRepository.save(developer);//save 통해 영속화 (DB 저장), business logic ends
    }
}
