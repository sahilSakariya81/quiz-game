package com.example.quizgame.repository;

import com.example.quizgame.model.QuestionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<QuestionModel,Integer> {
}
