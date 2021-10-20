package com.example.spring.oct.service;

import com.example.spring.oct.code.StatusCode;
import com.example.spring.oct.dto.*;
import com.example.spring.oct.entity.Developer;
import com.example.spring.oct.entity.RetiredDeveloper;
import com.example.spring.oct.exception.DMakerException;
import com.example.spring.oct.repository.DeveloperRepository;
import com.example.spring.oct.repository.RetiredDeveloperRepository;
import com.example.spring.oct.type.DeveloperLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.spring.oct.constant.DMakerConstant.MAX_JUNIOR_EXPERIENCE_YEARS;
import static com.example.spring.oct.constant.DMakerConstant.MIN_SENIOR_EXPERIENCE_YEARS;
import static com.example.spring.oct.exception.DMakerErrorCode.*;


//서비스 레이어, 비즈니스 로직, @Required.. 예전 @Autowired나 @Inject.. 서비스 단독 하는 문제; 그 다음 생성자
//생성자도 repository 여러개면 또 불편하므로 private final 기본 생성자 자동으로 만들어줌.
@Slf4j
@Service
@RequiredArgsConstructor
public class DMakerService {
    @Value("${developer.level.min.senior}")
    private final Integer minSeniorYears;
    private final DeveloperRepository developerRepository;
    private final RetiredDeveloperRepository retiredDeveloperRepository;
    //ACID(Atomicity, Consistency, Isolation, Durability)
    @Transactional
    public CreateDeveloper.Response createDeveloper(
            CreateDeveloper.Request request
    ) {
        validateCreateDeveloperRequest(request); //validation과 save 동작여부 검증 가능

        //business logic starts
        //save 통해 영속화 (DB 저장), business logic ends
        return CreateDeveloper.Response.fromEntity(
                developerRepository.save(createDeveloperFromRequest(request))
        );
    }

    public Developer createDeveloperFromRequest(CreateDeveloper.Request request) {
        return Developer.builder()
                .developerLevel(request.getDeveloperLevel())
                .developerSkillType(request.getDeveloperSkillType())
                .experienceYears(request.getExperienceYears())
                .memberId(request.getMemberId())
                .statusCode(StatusCode.EMPLOYED)
                .name(request.getName())
                .age(request.getAge())
                .build();

    }

    private void validateCreateDeveloperRequest(
            @NonNull CreateDeveloper.Request request
    ) {
        //business validation
        request.getDeveloperLevel().validateExperienceYears(request.getExperienceYears());
       //try{//외부 API 사용시 try-catch 이용
        developerRepository.findByMemberId(
                request.getMemberId()
                )
                .ifPresent((developer -> {
                    throw new DMakerException(DUPLICATED_MEMBER_ID);
                }));

    }
    @Transactional(readOnly = true)
    public List<DeveloperDto> getAllEmployedDevelopers() {
        return developerRepository.findDevelopersByStatusCodeEquals(
                StatusCode.EMPLOYED
                ).stream().map(DeveloperDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public DeveloperDetailDto getDeveloperDetail(String memberId) {
        return DeveloperDetailDto.fromEntity(getDeveloperByMemberId(memberId));
    }

    private Developer getDeveloperByMemberId(String memberId) {
        return developerRepository.findByMemberId(memberId)
                .orElseThrow(()-> new DMakerException(NO_DEVELOPER)
        );
    }



    @Transactional
    public DeveloperDetailDto editDeveloper(
            String memberId, EditDeveloper.Request request
    ) {
        request.getDeveloperLevel().validateExperienceYears(
                request.getExperienceYears()
        );
        return DeveloperDetailDto.fromEntity(
                getUpdatedDeveloperFromRequest(
                        request,
                        getDeveloperByMemberId(memberId)
                )
        );
    }

    private Developer getUpdatedDeveloperFromRequest(
            EditDeveloper.Request request, Developer developer
    ) {
        developer.setDeveloperLevel(request.getDeveloperLevel());
        developer.setDeveloperSkillType(request.getDeveloperSkillType());
        developer.setExperienceYears(request.getExperienceYears());

        return developer;
    }

    private void validateDeveloperLevel(
            DeveloperLevel developerLevel, Integer experienceYears
    ) {
        developerLevel.validateExperienceYears(experienceYears);
    }

    @Transactional //AOP
    public DeveloperDetailDto deleteDeveloper(String memberId) {
        //1. EMPLOYED -> RETIRED
        Developer developer = developerRepository.findByMemberId(memberId)
                .orElseThrow(() -> new DMakerException(NO_DEVELOPER));

        developer.setStatusCode(StatusCode.RETIRED);

        RetiredDeveloper retiredDeveloper = RetiredDeveloper.builder()
                .memberId(memberId)
                .name(developer.getName())
                .build();
        retiredDeveloperRepository.save(retiredDeveloper);
        return DeveloperDetailDto.fromEntity(developer);
    }
}
