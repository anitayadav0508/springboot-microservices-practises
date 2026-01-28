package com.__2_Microservie_quiz_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "quiz")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    /*We have a requirement that one question can be in multiple quiz like in case of JAVA-1,JAVA-2 both quiz contain same question*/

    /*if one to one mapping in that case  1 question  in one quiz*/
    /* if one to many means 1 quiz contain multiple question but same question can not be in 2 different quiz.
    * */

    /*if many to many means 1 question can have in multiple quiz and similar one quiz contain multiple question
    *  1 QUIZ - > Have Multiple Question
    *  1 Question -> CAN HAVE IN Multiple QUIZ
    * */

    /*So Many to Many Mapping is possible in that case only because 1 question can be in multiple quiz*/

    /*Here we can't use ManyToMany annotation because we having numbers which we saved i.e use List<Integer> so when you have numbers or a values we use annotation @ElementCollection instead of entity List<Question> here we are saving question's Ids instead of questions*/
    @ElementCollection
    private List<Integer> questionIds;


}
