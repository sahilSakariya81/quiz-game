package com.example.quizgame.dto;

import org.springframework.http.HttpStatus;

public class UserResponseDTO {
    private HttpStatus status;
    private String msg;

    public UserResponseDTO(HttpStatus status, String msg) {
        this.status = status;
        this.msg = msg;
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
