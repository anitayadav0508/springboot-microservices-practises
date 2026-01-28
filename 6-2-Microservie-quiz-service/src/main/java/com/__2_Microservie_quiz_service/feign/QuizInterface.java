package com.__2_Microservie_quiz_service.feign;

import com.__2_Microservie_quiz_service.dto.QuestionWrapper;
import com.__2_Microservie_quiz_service.dto.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("question-service")
public interface QuizInterface {
    @GetMapping("question/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam Integer numQuestions, @RequestParam String categoryName);

    /*Here we are expecting quiz application send list of questionIds to get Questions respective and why
     we use QuestionWrapper because in Question entity we have rightAnsewer which we don't want to showcase to user*/

    @PostMapping("question/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds);


    @PostMapping("question/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);


}
