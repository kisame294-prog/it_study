package com.yattsun.it_study.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "questions")
/*一問一答問題データ*/
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;
    private Integer answer;
    private String explanation;
    private String category;
}
