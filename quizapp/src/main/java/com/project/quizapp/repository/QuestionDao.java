package com.project.quizapp.repository;

import com.project.quizapp.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {

    public List<Question> findByCategory(String category);

    // Native query for random questions (PostgreSQL uses RANDOM())
    @Query(value = "SELECT * FROM question q WHERE q.category = :category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(@Param("category") String category, @Param("numQ") Integer numQ);
}
