package com.yattsun.it_study.controller;

import com.yattsun.it_study.entity.Question;
import com.yattsun.it_study.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/questions")
public class QuestionRestController {
    private final QuestionService questionService;

    public QuestionRestController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/{id}")
    public Question getQuestion(@PathVariable Long id){
        return questionService.getQuestion(id);
    }
}
