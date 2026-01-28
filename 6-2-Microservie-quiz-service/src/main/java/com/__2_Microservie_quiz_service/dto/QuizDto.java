package com.__2_Microservie_quiz_service.dto;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

@Data
public class QuizDto {


    private String category;
    private Integer numQuestions;
    private String title;
}
