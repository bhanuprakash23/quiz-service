package com.bhanu.quizservice.dao;

import com.bhanu.quizservice.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizDao extends JpaRepository<Quiz, Integer> {
    //List<Questions> findRandomQuestionsByCategory(String category, int numQ);
}
