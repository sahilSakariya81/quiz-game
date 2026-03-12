package com.example.quizgame.dto;

import org.springframework.http.HttpStatus;

public class QuestionResponseDTO {

    private QuestionDTO dto;
    HttpStatus status;
    String msg;

    public QuestionResponseDTO(QuestionDTO dto, HttpStatus status, String msg) {
        this.dto = dto;
        this.status = status;
        this.msg = msg;
    }

    public QuestionDTO getDto() {
        return dto;
    }

    public void setDto(QuestionDTO dto) {
        this.dto = dto;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
