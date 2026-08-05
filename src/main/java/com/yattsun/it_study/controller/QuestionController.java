package com.yattsun.it_study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuestionController {
    @GetMapping("/")
    public String index(){
        return "quiz";
    }
}
