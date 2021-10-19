package com.example.spring.oct.dto;

import com.example.spring.oct.entity.Developer;
import com.example.spring.oct.exception.DMakerErrorCode;
import com.example.spring.oct.type.DeveloperLevel;
import com.example.spring.oct.type.DeveloperSkillType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeveloperValidationDto {
    private DMakerErrorCode errorCode;
    private String errorMessage;

    }

