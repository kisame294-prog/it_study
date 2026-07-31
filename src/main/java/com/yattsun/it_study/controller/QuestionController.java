package com.yattsun.it_study.controller;

import com.yattsun.it_study.dto.AnswerRequest;
import com.yattsun.it_study.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/")
    public String index(){
        return "quiz";
    }

    @PostMapping("/answer")
    public boolean answer(@RequestBody AnswerRequest answerRequest){
        return questionService.checkAnswer(
                answerRequest.getQuestionId(),
                answerRequest.getAnswer()
        );
    }
}
