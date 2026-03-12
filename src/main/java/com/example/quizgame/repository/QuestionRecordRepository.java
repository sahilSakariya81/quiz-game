package com.example.quizgame.repository;

import com.example.quizgame.model.UserQuestionsRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRecordRepository extends JpaRepository<UserQuestionsRecord,Integer> {
}
