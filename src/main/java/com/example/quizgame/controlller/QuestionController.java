package com.example.quizgame.controlller;


import com.example.quizgame.model.QuestionModel;
import com.example.quizgame.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping("saveAllQuestion")
    public void saveAll(@RequestBody List<QuestionModel> list){
        questionService.saveAll(list);
    }
}
