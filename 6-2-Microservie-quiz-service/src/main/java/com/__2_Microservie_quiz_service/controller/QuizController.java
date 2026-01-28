package com.__2_Microservie_quiz_service.controller;


import com.__2_Microservie_quiz_service.dto.QuestionWrapper;
import com.__2_Microservie_quiz_service.dto.QuizDto;
import com.__2_Microservie_quiz_service.dto.Response;
import com.__2_Microservie_quiz_service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* http://localhost:8080/quiz/create?category=Java&numQ=5&title=JQuiz */
@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
       return quizService.createQuiz(quizDto.getCategory(),quizDto.getNumQuestions(),quizDto.getTitle());

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable("id") Integer quizId){

        return quizService.getQuizQuestions(quizId);

    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> calculateScore(@PathVariable("id") Integer quizId, @RequestBody List<Response> response){
        return quizService.calculateScore(quizId,response);
    }
}
