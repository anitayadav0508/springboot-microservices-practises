package com.__1_Microservie_question_service.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Response {

    private Integer id; // represent question id
    private String response; // represent what is the option/answer selected by user
}
