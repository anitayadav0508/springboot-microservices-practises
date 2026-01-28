package com.__2_Microservie_quiz_service.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Response {

    private Integer id;
    private String response;
}
