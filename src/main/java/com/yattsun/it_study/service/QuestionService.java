package com.yattsun.it_study.service;

import com.yattsun.it_study.entity.Question;
import com.yattsun.it_study.repository.QuestionRepository;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question getQuestion(Long id){
        return questionRepository.findById(id)
                .orElseThrow();
    }

}
