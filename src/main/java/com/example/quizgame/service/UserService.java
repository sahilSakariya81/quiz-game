package com.example.quizgame.service;

import com.example.quizgame.dto.*;
import com.example.quizgame.model.QuestionModel;
import com.example.quizgame.model.UserModel;
import com.example.quizgame.model.UserQuestionsRecord;
import com.example.quizgame.repository.QuestionRecordRepository;
import com.example.quizgame.repository.QuestionRepository;
import com.example.quizgame.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    QuestionRecordRepository questionRecordRepository;


    public UserResponseDTO login(UserModel model) {
        String name = userRepository.checkUser(model.getUsername());
        if(name == null){
            userRepository.save(model);
            UserResponseDTO dto = new UserResponseDTO(HttpStatus.OK,"Login successfully");
            return dto;
        }else{
            UserResponseDTO dto = new UserResponseDTO(HttpStatus.OK,"User ALready Exist");
            return dto;
        }

    }

    public QuestionResponseDTO getQuestion(String user) {

        String name = userRepository.checkUser(user);
        if(name == null){
            QuestionResponseDTO dto = new QuestionResponseDTO(null,HttpStatus.OK,"User not Exist") ;
            return dto;
        }else {

            int attemptedQues = userRepository.countAttemptedQuestion(name);
            if(attemptedQues >= 5){
                String score = userRepository.getUserScore(user);
                QuestionResponseDTO dto = new QuestionResponseDTO(null,HttpStatus.OK,"All Questions Are Done!!!  Your Score is "+score+" Out Of 5") ;
                return dto;
            }

//            Random random = new Random();
//            int qNo = random.nextInt(25)+1;
//
//            String question = userRepository.checkQuestion(user,qNo);
//
//            while (question != null){
//                qNo = random.nextInt(25)+1;
//                question = userRepository.checkQuestion(user,qNo);
//            }

            QuestionModel q = userRepository.getRandomQuestion(user);

            if (q == null) {
                return new QuestionResponseDTO(null, HttpStatus.OK, "No More Questions Available");
            }

            questionRecordRepository.save(new UserQuestionsRecord(name,q.getqId()));

            userRepository.updateAttemptedQuestion(name,attemptedQues+1);


            QuestionModel q1 = questionRepository.findById(q.getqId()).orElse(null);

            QuestionDTO dto = new QuestionDTO(q1.getqId(), q1.getQuestion(), q1.getOptionA(),q1.getOptionB(),q1.getOptionC(),q1.getOptionD());
            QuestionResponseDTO questionResponseDTO = new QuestionResponseDTO(dto,HttpStatus.OK,"Question Fetched Succeessfully");

            return questionResponseDTO;
        }

    }

    public SubmitResponseDTO submitAnswer(SubmitRequestDTO requestDTO){

        String checkQue = userRepository.checkQuestion(requestDTO.getUser(), requestDTO.getqId());
        if(checkQue == null){
            return new SubmitResponseDTO(HttpStatus.OK,"Invalid Question");
        }

        boolean isSubmit = userRepository.isSubmited(requestDTO.getUser(), requestDTO.getqId());
        if(isSubmit){
            return new SubmitResponseDTO(HttpStatus.OK,"You Already Submited This Question");
        }
        QuestionModel questionModel = questionRepository.findById(requestDTO.getqId()).orElse(null);

        String corrAns = questionModel.getAnswer();
        if(corrAns.equals(requestDTO.getSelectedOption())){
            userRepository.updateScoreQuestion(requestDTO.getUser());
            int a = userRepository.updateSubmit(requestDTO.getUser(),requestDTO.getqId());
            if(a > 0){
                System.out.println("updated sucessfully");
            }else{
                System.out.println("Filed");
            }
        }
        return new SubmitResponseDTO(HttpStatus.OK,"Correct Option : "+corrAns);


    }
}
