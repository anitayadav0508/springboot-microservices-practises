package com.__1_Microservie_question_service.service;


import com.__1_Microservie_question_service.dao.QuestionDao;
import com.__1_Microservie_question_service.dto.QuestionWrapper;
import com.__1_Microservie_question_service.dto.Response;
import com.__1_Microservie_question_service.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions(){
        try{
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<List<Question>> getAllQuestionsByCategory(String category){
        try{
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> addQuestion(Question question){
        try{
            questionDao.save(question);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Failed to add Question: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> updateQuestion(Integer id, Question question){
        try{
            Question existingQuestion = questionDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found with id: " + id));
        
            // Update only the fields that are explicitly provided in the JSON request
            // If a field is not provided in JSON (null), preserve the previous value from the database
            // This ensures partial updates don't accidentally set fields to null
            if (question.getQuestionTitle() != null) {
                existingQuestion.setQuestionTitle(question.getQuestionTitle());
            }
            if (question.getOption1() != null) {
                existingQuestion.setOption1(question.getOption1());
            }
            if (question.getOption2() != null) {
                existingQuestion.setOption2(question.getOption2());
            }
            if (question.getOption3() != null) {
                existingQuestion.setOption3(question.getOption3());
            }
            if (question.getOption4() != null) {
                existingQuestion.setOption4(question.getOption4());
            }
            if (question.getRightAnswer() != null) {
                existingQuestion.setRightAnswer(question.getRightAnswer());
            }
            if (question.getDifficultylevel() != null) {
                existingQuestion.setDifficultylevel(question.getDifficultylevel());
            }
            if (question.getCategory() != null) {
                existingQuestion.setCategory(question.getCategory());
            }
        
            // Save the updated existing question
            questionDao.save(existingQuestion);
            return new ResponseEntity<>("Question updated successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            // Handle business logic exceptions (like "not found")
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            // Handle unexpected exceptions
            e.printStackTrace();
            return new ResponseEntity<>("Question not updated: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Question> deleteQuestion(Integer id){
        try{
            Question qus = questionDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found with id: " + id));
        
            // Only delete if question exists
            questionDao.deleteById(id);
            return new ResponseEntity<>(qus, HttpStatus.OK);
        } catch (RuntimeException e) {
            // Handle "not found" exception
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            // Handle unexpected exceptions
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, Integer noOfQuestion) {
        List<Integer> questionsId =   questionDao.findRandomQuestionsByCategory(categoryName,noOfQuestion);

        return new ResponseEntity<>(questionsId,HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromid(List<Integer> questionIds) {

        List<QuestionWrapper> wrappers =  new ArrayList<>();



       List<Question> questions =   questionDao.findAllById(questionIds);

       for(Question question : questions){

           QuestionWrapper wrapper = new QuestionWrapper();

           wrapper.setId(question.getId());
           wrapper.setQuestionTitle(question.getQuestionTitle());
           wrapper.setDifficultylevel(question.getDifficultylevel());
           wrapper.setOption2(question.getOption2());
           wrapper.setOption1(question.getOption1());
           wrapper.setOption3(question.getOption3());
           wrapper.setOption4(question.getOption4());

           wrappers.add(wrapper);
       }

        return new ResponseEntity<>(wrappers,HttpStatus.OK);

    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {

        int score = 0;
        for (Response response : responses) {
            Question question = questionDao.findById(response.getId()).orElse(null);
            if (question == null) continue;

            // Compare with trim() to ignore leading/trailing whitespace; null-safe
            String rightAnswer = question.getRightAnswer() != null ? question.getRightAnswer().trim() : "";
            String userResponse = response.getResponse() != null ? response.getResponse().trim() : "";
            if (Objects.equals(rightAnswer, userResponse)) {
                score++;
            }
        }

        return new ResponseEntity<>(score, HttpStatus.OK);
    }


}
