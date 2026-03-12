package com.example.quizgame.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_questions_record")
public class UserQuestionsRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private int qId;
    @Column(name = "is_submit" , columnDefinition = "boolean default false")
    private boolean isSubmited;

    public UserQuestionsRecord(String username, int qId) {
        this.username = username;
        this.qId = qId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getqId() {
        return qId;
    }

    public void setqId(int qId) {
        this.qId = qId;
    }

    public boolean isSubmited() {
        return isSubmited;
    }

    public void setSubmited(boolean submited) {
        isSubmited = submited;
    }
}
