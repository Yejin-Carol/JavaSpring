package com.example.spring.oct.entity;

import com.example.spring.oct.type.DeveloperLevel;
import com.example.spring.oct.type.DeveloperSkillType;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class RetiredDeveloper {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        protected Long id;

        private String memberId;
        private String name;

        //App에 EnabledJpaAuditing 추가
        @CreatedDate
        private LocalDateTime createdAt;

        @LastModifiedDate
        private LocalDateTime updatedAt;

    }
