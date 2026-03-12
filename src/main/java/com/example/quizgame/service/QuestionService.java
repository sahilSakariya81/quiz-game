package com.example.quizgame.service;

import com.example.quizgame.model.QuestionModel;
import com.example.quizgame.repository.QuestionRepository;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public void saveAll(List<QuestionModel> modelList){
        questionRepository.saveAll(modelList);
    }
}
