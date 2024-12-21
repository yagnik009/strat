package com.Quize.start.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class QuizSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessionId;
    @OneToMany
    private List<AnsweredQuestion> answeredQuestions;
    private int score;



    public QuizSession(List<AnsweredQuestion> answeredQuestions, int score) {
        this.answeredQuestions = answeredQuestions;
        this.score = score;
    }

    QuizSession(){

    }


    // Getters and setters
    public Long getSessionId() { return sessionId; }
    public void setSessionId(Long sessionId) { this.sessionId = sessionId; }

    public List<AnsweredQuestion> getAnsweredQuestions() { return answeredQuestions; }
    public void setAnsweredQuestions(List<AnsweredQuestion> answeredQuestions) { this.answeredQuestions = answeredQuestions; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
}
