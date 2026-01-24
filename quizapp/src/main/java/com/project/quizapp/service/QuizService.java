package com.project.quizapp.service;

import com.project.quizapp.dto.QuestionWrapper;
import com.project.quizapp.dto.Response;
import com.project.quizapp.entity.Question;
import com.project.quizapp.entity.Quiz;
import com.project.quizapp.repository.QuestionDao;
import com.project.quizapp.repository.QuizDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;

    @Autowired
    private QuestionDao questionDao;


    public ResponseEntity<String> createQuiz(String category, Integer noOfQuestion, String title) {

        //now create Quiz

        Quiz quiz = new Quiz();
        quiz.setTitle(title);

        /*now we need to bring question base on category and limit number
         of question for that question can fetch from questionDao only and QuestionDao have a method which take category and noOfQuestion we want as
         parameter
         */

       List<Question> questions = questionDao.findRandomQuestionsByCategory(category,noOfQuestion);
       quiz.setQuestions(questions);

       quizDao.save(quiz);
       return new ResponseEntity<>("Sucess", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer quizId) {

       Optional<Quiz> quiz = quizDao.findById(quizId);

       List<QuestionWrapper> questionWrappers = new ArrayList<>();

      List<Question> questions  = quiz.get().getQuestions();

      for(Question question : questions){
          QuestionWrapper questionWrapper = new QuestionWrapper(question.getId(),question.getQuestionTitle(),question.getOption1(),question.getOption2(),question.getOption3(),
                  question.getCategory(), question.getOption4(),question.getDifficultylevel());

          questionWrappers.add(questionWrapper);
      }

      return new ResponseEntity<>(questionWrappers,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateScore(Integer quizId, List<Response> responses) {

        Optional<Quiz> quiz = quizDao.findById(quizId);
        if (quiz.isEmpty()) {
            return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
        }

        List<Question> questions = quiz.get().getQuestions();
        int score = 0;

        // Create a map of question ID to question for quick lookup
        for (Response userResponse : responses) {
            // Find the question by ID from the quiz's questions
            Optional<Question> question = questions.stream()
                    .filter(q -> q.getId().equals(userResponse.getId()))
                    .findFirst();

            if (question.isPresent()) {
                // Compare user's response with the correct answer (case-insensitive)
                String userAnswer = userResponse.getResponse() != null ? userResponse.getResponse().trim() : "";
                String correctAnswer = question.get().getRightAnswer() != null ? question.get().getRightAnswer().trim() : "";
                
                if (userAnswer.equalsIgnoreCase(correctAnswer)) {
                    score++;
                }
            }
        }

        return new ResponseEntity<>(score, HttpStatus.OK);
    }
}
