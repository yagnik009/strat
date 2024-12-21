package com.Quize.start.service;


import com.Quize.start.entity.*;
import com.Quize.start.repository.AnsweredQuestionRepository;
import com.Quize.start.repository.QuestionRepository;
import com.Quize.start.repository.QuizSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuizService {

    @Autowired
    private QuizSessionRepository quizSessionRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnsweredQuestionRepository answeredQuestionRepository;

    public QuizSession startNewSession() {
        QuizSession session = new QuizSession(new ArrayList<>(), 0); // No sessionId required
        session = quizSessionRepository.save(session); // Save and retrieve the generated session
        return session; // Return the saved session
    }

    public List<Question> addQuestions(List<Question> questions) {
        return questionRepository.saveAll(questions);
    }

    public Question getRandomQuestion(Long sessionId) {
        QuizSession session = quizSessionRepository.findById(sessionId).orElseThrow(() -> new IllegalArgumentException("Session not found."));

        Set<Long> answeredQuestionIds = new HashSet<>();
        for (AnsweredQuestion answered : session.getAnsweredQuestions()) {
            answeredQuestionIds.add(answered.getQuestion().getId());
        }

        return questionRepository.findAll().stream()
                .filter(question -> !answeredQuestionIds.contains(question.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No more questions available. Please restart the quiz."));
    }

    public SubmitAnswerResponse submitAnswer(Long sessionId, Long questionId, String answer) {
        QuizSession session = quizSessionRepository.findById(sessionId)
                .orElseThrow(() -> new IllegalArgumentException("Session not found."));

        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new IllegalArgumentException("Question not found."));

        System.out.println("Submitted Answer: " + answer);
        System.out.println("Correct Answer: " + question.getCorrectAnswer());

        boolean isCorrect = question.getCorrectAnswer().trim().equalsIgnoreCase(answer.trim());

        AnsweredQuestion answeredQuestion = new AnsweredQuestion(question, answer, isCorrect);
        answeredQuestionRepository.save(answeredQuestion);

        session.getAnsweredQuestions().add(answeredQuestion);

        if (isCorrect) {
            session.setScore(session.getScore() + 1);
        }

        quizSessionRepository.save(session);

        String message = isCorrect ? "Correct answer!" : "Incorrect answer!";
        return new SubmitAnswerResponse(isCorrect, message, session.getScore());
    }


    public QuizSummaryResponse getSummary(Long sessionId) {
        QuizSession session = quizSessionRepository.findById(sessionId).orElseThrow(() -> new IllegalArgumentException("Session not found."));

        int correctAnswers = 0;
        int incorrectAnswers = 0;

        for (AnsweredQuestion answered : session.getAnsweredQuestions()) {
            if (answered.isCorrect()) {
                correctAnswers++;
            } else {
                incorrectAnswers++;
            }
        }

        QuizSummaryResponse summary = new QuizSummaryResponse();
        summary.setTotalQuestionsAnswered(session.getAnsweredQuestions().size());
        summary.setCorrectAnswers(correctAnswers);
        summary.setIncorrectAnswers(incorrectAnswers);
        summary.setQuestions(session.getAnsweredQuestions());

        return summary;
    }
}
