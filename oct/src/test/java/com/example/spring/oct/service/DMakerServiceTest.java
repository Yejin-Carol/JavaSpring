package com.example.spring.oct.service;

import com.example.spring.oct.dto.CreateDeveloper;
import com.example.spring.oct.dto.DeveloperDetailDto;
import com.example.spring.oct.entity.Developer;
import com.example.spring.oct.exception.DMakerErrorCode;
import com.example.spring.oct.exception.DMakerException;
import com.example.spring.oct.repository.DeveloperRepository;
import com.example.spring.oct.repository.RetiredDeveloperRepository;
import com.example.spring.oct.type.DeveloperLevel;
import com.example.spring.oct.type.DeveloperSkillType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.example.spring.oct.code.StatusCode.EMPLOYED;
import static com.example.spring.oct.constant.DMakerConstant.MAX_JUNIOR_EXPERIENCE_YEARS;
import static com.example.spring.oct.constant.DMakerConstant.MIN_SENIOR_EXPERIENCE_YEARS;
import static com.example.spring.oct.exception.DMakerErrorCode.DUPLICATED_MEMBER_ID;
import static com.example.spring.oct.exception.DMakerErrorCode.LEVEL_EXPERIENCE_YEARS_NOT_MATCHED;
import static com.example.spring.oct.type.DeveloperLevel.*;
import static com.example.spring.oct.type.DeveloperSkillType.FRONT_END;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DMakerServiceTest {
    @Mock
    private DeveloperRepository developerRepository;

    @Mock
    private RetiredDeveloperRepository retiredDeveloperRepository;

    @InjectMocks
    private DMakerService dMakerService;

    private final Developer defaultDeveloper = Developer.builder()
            .developerLevel(SENIOR)
            .developerSkillType(FRONT_END)
            .experienceYears(12)
            .statusCode(EMPLOYED)
            .name("name")
            .age(12)
            .build();

    private CreateDeveloper.Request getCreateRequest(
            DeveloperLevel developerLevel,
            DeveloperSkillType developerSkillType,
            Integer experienceYears

    ) {
         return  CreateDeveloper.Request.builder()
            .developerLevel(developerLevel)
            .developerSkillType(developerSkillType)
            .experienceYears(experienceYears)
            .memberId("memberId")
            .name("name")
            .age(32)
            .build();
    }
    private DMakerException dMakerException;

    //1. 일반적인 logic test
    @Test
    public void testSomething() {
        //given
        given(developerRepository.findByMemberId(anyString()))
                .willReturn(Optional.of(defaultDeveloper));
        //when
        DeveloperDetailDto developerDetail = dMakerService.getDeveloperDetail("memberId");
        //then
        assertEquals(SENIOR, developerDetail.getDeveloperLevel());
        assertEquals(FRONT_END, developerDetail.getDeveloperSkillType());
        assertEquals(EMPLOYED, developerDetail.getStatusCode());

    }
    //2. createDeveloper + 실제 DB 저장 데이터 확인 (혹은 외부 API 데이터 확인하고 싶을때, captor사용)
    @Test
    void createDeveloperTest_success() {
        //given
        given(developerRepository.findByMemberId(anyString()))
           .willReturn(Optional.empty());
        given(developerRepository.save(any()))
                .willReturn(defaultDeveloper);
        ArgumentCaptor<Developer> captor =
                ArgumentCaptor.forClass(Developer.class);

        //when
        dMakerService.createDeveloper(getCreateRequest(SENIOR, FRONT_END, 12));

        //then
        verify(developerRepository, times(1))
                .save(captor.capture());
        Developer savedDeveloper = captor.getValue();
        assertEquals(SENIOR, savedDeveloper.getDeveloperLevel());
        assertEquals(FRONT_END, savedDeveloper.getDeveloperSkillType());
        assertEquals(12, savedDeveloper.getExperienceYears());
    }

    @Test
    void createDeveloperTest_fail_with_unmatched_level() {
        //given
        //when
        //then
        DMakerException dMakerException = assertThrows(DMakerException.class,
                () -> dMakerService.createDeveloper(
                        getCreateRequest(JUNIOR, FRONT_END,
                                MAX_JUNIOR_EXPERIENCE_YEARS +1)
                )
        );

        assertEquals(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED,
                dMakerException.getDMakerErrorCode()
        );

        dMakerException = assertThrows(DMakerException.class,
                () -> dMakerService.createDeveloper(
                        getCreateRequest(JUNGNIOR, FRONT_END,
                                MIN_SENIOR_EXPERIENCE_YEARS +1)
                )
        );
        assertEquals(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED,
                dMakerException.getDMakerErrorCode()
        );

        dMakerException = assertThrows(DMakerException.class,
                () -> dMakerService.createDeveloper(
                        getCreateRequest(SENIOR, FRONT_END,
                                MIN_SENIOR_EXPERIENCE_YEARS - 1)
                )
        );
        assertEquals(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED,
                dMakerException.getDMakerErrorCode()
        );
    }


    //검증 실패시, Exception 날려주는데, 그 Exception을 어떻게 검증하는지 확인하고 싶을때
    @Test
    void createDeveloperTest_failed_with_duplicated() {
        //given
        given(developerRepository.findByMemberId(anyString()))
                .willReturn(Optional.of(defaultDeveloper));

        //when
        //then
        DMakerException dMakerException = assertThrows(DMakerException.class,
                () -> dMakerService.createDeveloper(
                        getCreateRequest(SENIOR, FRONT_END,MIN_SENIOR_EXPERIENCE_YEARS))
        );

        assertEquals(DUPLICATED_MEMBER_ID, dMakerException.getDMakerErrorCode());

    }


}
