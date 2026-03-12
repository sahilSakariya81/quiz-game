package com.example.quizgame.controlller;

import com.example.quizgame.dto.*;
import com.example.quizgame.model.UserModel;
import com.example.quizgame.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("login")
    public UserResponseDTO login(@RequestBody UserModel model){
        return userService.login(model);
    }

    @GetMapping("getQuestion/{user}")
    public QuestionResponseDTO getQuestion(@PathVariable String user){
        return userService.getQuestion(user);
    }

    @PostMapping("submitAns")
    public SubmitResponseDTO submitAnswer(@RequestBody SubmitRequestDTO submitRequestDTO){
        return userService.submitAnswer(submitRequestDTO);
    }
}
