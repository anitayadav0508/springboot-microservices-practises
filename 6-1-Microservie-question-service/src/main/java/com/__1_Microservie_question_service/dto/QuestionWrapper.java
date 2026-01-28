package com.__1_Microservie_question_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*Why we need this because in QuestionEntity we have answer as well so we don't want to show answer of question from Question list
*  */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionWrapper {

    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String difficultylevel;
    private String category;
}
