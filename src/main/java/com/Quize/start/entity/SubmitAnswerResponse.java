package com.Quize.start.entity;

public class SubmitAnswerResponse {
    private boolean correct;
    private String message;
    private int currentScore;

    public SubmitAnswerResponse(boolean correct, String message, int currentScore) {
        this.correct = correct;
        this.message = message;
        this.currentScore = currentScore;
    }

    public boolean isCorrect() { return correct; }
    public void setCorrect(boolean correct) { this.correct = correct; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public int getCurrentScore() { return currentScore; }
    public void setCurrentScore(int currentScore) { this.currentScore = currentScore; }
}
