package com.yattsun.it_study.controller;

import com.yattsun.it_study.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/")
    public String categories(Model model){
        model.addAttribute("categories",questionService.getCategories());

        return "categories";
    }

    @GetMapping("/quiz")
    public String quiz(@RequestParam String category, Model model){
        model.addAttribute("category",category);
        return "quiz";
    }
}
