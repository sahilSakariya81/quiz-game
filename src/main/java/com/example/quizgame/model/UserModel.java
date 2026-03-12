package com.example.quizgame.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class UserModel {

    @Id
    private String username;

    @Column(name = "question_attended",columnDefinition = "int default 0")
    private int questionAttend;

    @Column(name = "correct_answer",columnDefinition = "int default 0")
    private int correctAnswer;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getQuestionAttend() {
        return questionAttend;
    }

    public void setQuestionAttend(int questionAttend) {
        this.questionAttend = questionAttend;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
