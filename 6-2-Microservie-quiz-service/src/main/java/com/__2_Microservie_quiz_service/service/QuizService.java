package com.__2_Microservie_quiz_service.service;


import com.__2_Microservie_quiz_service.dao.QuizDao;
import com.__2_Microservie_quiz_service.dto.QuestionWrapper;
import com.__2_Microservie_quiz_service.dto.Response;
import com.__2_Microservie_quiz_service.entity.Quiz;
import com.__2_Microservie_quiz_service.feign.QuizInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;

    @Autowired
    private QuizInterface quizInterface;


  /*now we need to bring question base on category and limit number
         of question for that question can fetch from questionDao only and QuestionDao have a method which take category and noOfQuestion we want as
         parameter
         */

    public ResponseEntity<String> createQuiz(String category, Integer noOfQuestion, String title) {


        /*Here i need to send http request from quiz microservice to question microservice i.e quiz service need to discover question service so discovery
        can be done with the help of service registry so questionservice will register to eureka server or service registry  to communicate with Questionservice we use http request by feign client which say you just tell me with whom
        you want to connect instead of worrying about ip address and port */
        List<Integer> questions = quizInterface.getQuestionsForQuiz(noOfQuestion,category).getBody();
                //call the generate url from questionService microservice application

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizDao.save(quiz);



       return new ResponseEntity<>("Success", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer quizId) {

        Quiz quiz = quizDao.findById(quizId).get();

        ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsFromId(quiz.getQuestionIds());
        return questions;

    }

    public ResponseEntity<Integer> calculateScore(Integer quizId, List<Response> responses) {
        ResponseEntity<Integer> score =  quizInterface.getScore(responses);

        return score;


    }
}
