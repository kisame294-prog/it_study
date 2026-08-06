package com.yattsun.it_study.service;

import com.yattsun.it_study.dto.AnswerResponse;
import com.yattsun.it_study.entity.Question;
import com.yattsun.it_study.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question getQuestion(Long id) {
        return questionRepository.findById(id)
                .orElseThrow();
    }

    public List<String> getCategories(){
        return questionRepository.findCategories();
    }

    public List<Question> getQuestionByCategory(String category){
        return questionRepository.findByCategoryOrderByIdAsc(category);
    }

    /*ユーザーの解答があっているかどうか*/
    public AnswerResponse checkAnswer(Long questionId, Integer userAnswer) {
        Question question = questionRepository.findById(questionId)
                .orElseThrow();
        boolean correct = question.getAnswer().equals(userAnswer);

        AnswerResponse answerResponse = new AnswerResponse();

        answerResponse.setCorrect(correct);
        answerResponse.setExplanation(question.getExplanation());

        return answerResponse;
    }

}
