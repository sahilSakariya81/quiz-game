package com.example.quizgame.dto;

public class QuestionDTO {
    private int questionId;
    private String question;
    private String opA;
    private String opB;
    private String opC;
    private String opD;

    public QuestionDTO() {

    }

    public QuestionDTO(int questionId,String question, String opA, String opB, String opC, String opD) {
        this.questionId = questionId;
        this.question = question;
        this.opA = opA;
        this.opB = opB;
        this.opC = opC;
        this.opD = opD;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public String getOpA() {
        return opA;
    }

    public String getOpB() {
        return opB;
    }

    public String getOpC() {
        return opC;
    }

    public String getOpD() {
        return opD;
    }
}
