package com.project.quizapp.controller;

import com.project.quizapp.dto.QuestionWrapper;
import com.project.quizapp.dto.Response;
import com.project.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam("numQ") Integer noOfQuestion,
                                             @RequestParam String title){
       return quizService.createQuiz(category,noOfQuestion,title);

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable("id") Integer quizId){

        return quizService.getQuizQuestions(quizId);

    }

    @GetMapping("/submit/{id}")
    public ResponseEntity<Integer> calculateScore(@PathVariable("id") Integer quizId, @RequestBody List<Response> response){
        return quizService.calculateScore(quizId,response);
    }
}
