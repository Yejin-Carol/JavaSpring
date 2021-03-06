package com.example.spring.oct.repository;

import com.example.spring.oct.entity.Developer;
import com.example.spring.oct.entity.RetiredDeveloper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RetiredDeveloperRepository extends JpaRepository<RetiredDeveloper, Long> {
}
