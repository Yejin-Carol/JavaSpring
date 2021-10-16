package com.example.spring.oct.service;

import code.StatusCode;
import com.example.spring.oct.dto.CreateDeveloper;
import com.example.spring.oct.dto.DeveloperDetailDto;
import com.example.spring.oct.dto.DeveloperDto;
import com.example.spring.oct.dto.EditDeveloper;
import com.example.spring.oct.entity.Developer;
import com.example.spring.oct.entity.RetiredDeveloper;
import com.example.spring.oct.exception.DMakerException;
import com.example.spring.oct.repository.DeveloperRepository;
import com.example.spring.oct.repository.RetiredDeveloperRepository;
import com.example.spring.oct.type.DeveloperLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.spring.oct.exception.DMakerErrorCode.*;


//서비스 레이어, 비즈니스 로직, @Required.. 예전 @Autowired나 @Inject.. 서비스 단독 하는 문제; 그 다음 생성자
//생성자도 repository 여러개면 또 불편하므로 private final 기본 생성자 자동으로 만들어줌.

@Service
@RequiredArgsConstructor
public class DMakerService {
    private final DeveloperRepository developerRepository;
    private final RetiredDeveloperRepository retiredDeveloperRepository;
    //ACID(Atomicity, Consistency, Isolation, Durability)
    @Transactional
    public CreateDeveloper.Response createDeveloper(CreateDeveloper.Request request) {
        validateCreateDeveloperRequest(request);

        //business logic starts
        Developer developer = Developer.builder()
                .developerLevel(request.getDeveloperLevel())
                .developerSkillType(request.getDeveloperSkillType())
                .experienceYears(request.getExperienceYears())
                .memberId(request.getMemberId())
                .statusCode(StatusCode.EMPLOYED)
                .name(request.getName())
                .age(request.getAge())
                .build();//마지막에 꼭 build해야함. 중간에 하면 중간에 끝남.
        developerRepository.save(developer);//save 통해 영속화 (DB 저장), business logic ends
        return CreateDeveloper.Response.fromEntity(developer);
    }

    private void validateCreateDeveloperRequest(CreateDeveloper.Request request) {
    //business validation
        validateDeveloperLevel(
                request.getDeveloperLevel(),
                request.getExperienceYears()
                );

//        Optional<Developer> developer = developerRepository.findByMemberId(request.getMemberId());
//        if(developer.isPresent())
//            throw new DMakerException(DUPLICATED_MEMBER_ID);
        developerRepository.findByMemberId(request.getMemberId())
                .ifPresent((developer -> {
                    throw new DMakerException(DUPLICATED_MEMBER_ID);
                }));
    }

    public List<DeveloperDto> getAllEmployedDevelopers() {
        return developerRepository.findDevelopersByStatusCodeEquals(StatusCode.EMPLOYED)
                .stream().map(DeveloperDto::fromEntity)
                .collect(Collectors.toList());
    }

    public DeveloperDetailDto getDeveloperDetail(String memberId) {
        return developerRepository.findByMemberId(memberId)
                .map(DeveloperDetailDto::fromEntity)
                .orElseThrow(()-> new DMakerException(NO_DEVELOPER));

    }

    @Transactional
    public DeveloperDetailDto editDeveloper(String memberId, EditDeveloper.Request request) {
        validateEditDeveloperRequest(request, memberId);

        Developer developer = developerRepository.findByMemberId(memberId).orElseThrow(
                ()-> new DMakerException(NO_DEVELOPER)
        );

        developer.setDeveloperLevel(request.getDeveloperLevel());
        developer.setDeveloperSkillType(request.getDeveloperSkillType());
        developer.setExperienceYears(request.getExperienceYears());

        return DeveloperDetailDto.fromEntity(developer);
    }

    private void validateEditDeveloperRequest(EditDeveloper.Request request, String memberId) {
        validateDeveloperLevel(
                request.getDeveloperLevel(),
                request.getExperienceYears()
        );

    }

    private void validateDeveloperLevel(DeveloperLevel developerLevel, Integer experienceYears) {
        if (developerLevel == DeveloperLevel.SENIOR
                && experienceYears < 10) {
            throw new DMakerException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);//import static
        }
        if (developerLevel == DeveloperLevel.JUNGNIOR
                && (experienceYears < 4 || experienceYears > 10)) {
            throw new DMakerException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }
        if (developerLevel == DeveloperLevel.JUNIOR && experienceYears > 4) {
            throw new DMakerException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }
    }

    @Transactional
    public DeveloperDetailDto deleteDeveloper(String memberId) {
        //1. EMPLOYED -> RETIRED
        Developer developer = developerRepository.findByMemberId(memberId)
                .orElseThrow(() -> new DMakerException(NO_DEVELOPER));
        developer.setStatusCode(StatusCode.RETIRED);
        //developerRepository.save(developer);

        //Transaction-Atomicity
        //if(developer !=null) throw new DMakerException(NO_DEVELOPER);

        //2. save into RetiredDeveloper
        RetiredDeveloper retiredDeveloper = RetiredDeveloper.builder()
                .memberId(memberId)
                .name(developer.getName())
                .build();
        retiredDeveloperRepository.save(retiredDeveloper);
        return DeveloperDetailDto.fromEntity(developer);
    }
}
