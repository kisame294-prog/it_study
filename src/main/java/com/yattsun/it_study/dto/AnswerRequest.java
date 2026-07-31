package com.yattsun.it_study.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
/*ユーザーの解答データ*/
public class AnswerRequest {
    private Long questionId;
    private Integer answer;
}
