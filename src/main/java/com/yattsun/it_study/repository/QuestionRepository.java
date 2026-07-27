package com.yattsun.it_study.repository;

import com.yattsun.it_study.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository
        extends JpaRepository<Question, Long> {
}
