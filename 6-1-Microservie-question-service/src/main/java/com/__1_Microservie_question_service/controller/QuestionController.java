package com.__1_Microservie_question_service.controller;


import com.__1_Microservie_question_service.dto.QuestionWrapper;
import com.__1_Microservie_question_service.dto.Response;
import com.__1_Microservie_question_service.entity.Question;
import com.__1_Microservie_question_service.service.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    Environment environment;

    @GetMapping("/allQuestions")
    public ResponseEntity <List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getAllQuestionsBasedOnCategory(@PathVariable String category){

        return questionService.getAllQuestionsByCategory(category.toUpperCase());

    }

    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){

        return questionService.addQuestion(question);
    }


    @PutMapping("/update/{questionId}")
    public ResponseEntity<String> updateQuestion(@RequestBody Question question,@PathVariable("questionId") Integer id){

        return questionService.updateQuestion(id,question);
    }

    @DeleteMapping("/delete/{questionId}")
    public ResponseEntity<Question> deleteQuestion(@PathVariable("questionId") Integer id ){
        return questionService.deleteQuestion(id);
    }

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@ RequestParam Integer numQuestions,@RequestParam String categoryName){
        return questionService.getQuestionsForQuiz(categoryName,numQuestions);
    }

    /*Here we are expecting quiz spplication send list of questionIds to get Questions respective and why
     we use QuestionWrapper because in Question entity we have rightAnsewer which we don't want to showcase to user*/

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds){

        System.out.println(environment.getProperty("local.server.port"));
        return questionService.getQuestionsFromid(questionIds);
    }


    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){

        return questionService.getScore(responses);
    }

}
