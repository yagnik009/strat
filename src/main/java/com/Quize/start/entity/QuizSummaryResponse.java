package com.Quize.start.entity;

import java.util.List;

public class QuizSummaryResponse {
    private int totalQuestionsAnswered;
    private int correctAnswers;
    private int incorrectAnswers;
    private List<AnsweredQuestion> questions;

    public int getTotalQuestionsAnswered() { return totalQuestionsAnswered; }
    public void setTotalQuestionsAnswered(int totalQuestionsAnswered) { this.totalQuestionsAnswered = totalQuestionsAnswered; }

    public int getCorrectAnswers() { return correctAnswers; }
    public void setCorrectAnswers(int correctAnswers) { this.correctAnswers = correctAnswers; }

    public int getIncorrectAnswers() { return incorrectAnswers; }
    public void setIncorrectAnswers(int incorrectAnswers) { this.incorrectAnswers = incorrectAnswers; }

    public List<AnsweredQuestion> getQuestions() { return questions; }
    public void setQuestions(List<AnsweredQuestion> questions) { this.questions = questions; }
}

