package com.yattsun.it_study.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
/*問題の解説*/
public class AnswerResponse {
    private boolean correct;
    private String explanation;
}
