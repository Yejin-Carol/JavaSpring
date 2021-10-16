package com.example.spring.oct.entity;

import code.StatusCode;
import com.example.spring.oct.type.DeveloperLevel;
import com.example.spring.oct.type.DeveloperSkillType;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

//@builder, @NoArgs..,@AllArgs 항상 같이 쓸 것!

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Enumerated(EnumType.STRING)
    private DeveloperLevel developerLevel;

    @Enumerated(EnumType.STRING)
    private DeveloperSkillType developerSkillType;

    private Integer experienceYears;
    private String memberId;
    private String name;
    private Integer age;

    @Enumerated(EnumType.STRING)
    private StatusCode statusCode;
    //App에 EnabledJpaAuditing 추가
    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

}
