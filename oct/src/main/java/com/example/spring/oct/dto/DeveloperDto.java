package com.example.spring.oct.dto;

import com.example.spring.oct.entity.Developer;
import com.example.spring.oct.type.DeveloperLevel;
import com.example.spring.oct.type.DeveloperSkillType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class DeveloperDto {
    private DeveloperLevel developerLevel;
    private DeveloperSkillType developerSkillType;
    private String memberId;

    public static DeveloperDto fromEntity(Developer developer) {
        return DeveloperDto.builder()
                 .developerLevel(developer.getDeveloperLevel())
                 .developerSkillType(developer.getDeveloperSkillType())
                 .memberId(developer.getMemberId())
                 .build();
    }
}
