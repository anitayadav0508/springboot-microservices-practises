package com.project.quizapp.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Order(1) // Run early, before data.sql
public class TableInitializer implements InitializingBean {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void afterPropertiesSet() {
        // Create tables if they don't exist (Hibernate ddl-auto: create doesn't work eagerly)
        Session session = entityManager.unwrap(Session.class);
        
        session.doWork(connection -> {
            try (var statement = connection.createStatement()) {
                // Create question table if it doesn't exist
                var resultSet = statement.executeQuery(
                    "SELECT EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'question')"
                );
                if (resultSet.next() && !resultSet.getBoolean(1)) {
                    statement.execute(
                        "CREATE TABLE question (" +
                        "id SERIAL PRIMARY KEY, " +
                        "question_title VARCHAR(255), " +
                        "option1 VARCHAR(255), " +
                        "option2 VARCHAR(255), " +
                        "option3 VARCHAR(255), " +
                        "option4 VARCHAR(255), " +
                        "right_answer VARCHAR(255), " +
                        "difficultylevel VARCHAR(255), " +
                        "category VARCHAR(255)" +
                        ")"
                    );
                }
                
                // Create quiz table if it doesn't exist
                resultSet = statement.executeQuery(
                    "SELECT EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'quiz')"
                );
                if (resultSet.next() && !resultSet.getBoolean(1)) {
                    statement.execute(
                        "CREATE TABLE quiz (" +
                        "id SERIAL PRIMARY KEY, " +
                        "title VARCHAR(255)" +
                        ")"
                    );
                }
                
                // Create quiz_question join table if it doesn't exist
                resultSet = statement.executeQuery(
                    "SELECT EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'quiz_question')"
                );
                if (resultSet.next() && !resultSet.getBoolean(1)) {
                    statement.execute(
                        "CREATE TABLE quiz_question (" +
                        "quiz_id INTEGER NOT NULL, " +
                        "question_id INTEGER NOT NULL, " +
                        "PRIMARY KEY (quiz_id, question_id), " +
                        "FOREIGN KEY (quiz_id) REFERENCES quiz(id) ON DELETE CASCADE, " +
                        "FOREIGN KEY (question_id) REFERENCES question(id) ON DELETE CASCADE" +
                        ")"
                    );
                }
            }
        });
    }
}

