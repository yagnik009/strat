package com.Quize.start.controller;


import com.Quize.start.entity.Question;
import com.Quize.start.entity.QuizSession;
import com.Quize.start.entity.QuizSummaryResponse;
import com.Quize.start.entity.SubmitAnswerResponse;
import com.Quize.start.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("/AddQuestion")
    public List<Question> addQuestions(@RequestBody List<Question> questions) {
        return quizService.addQuestions(questions);
    }

    @PostMapping("/start")
    public QuizSession startQuiz() {
        return quizService.startNewSession();
    }

    @GetMapping("/question")
    public Question getQuestion(@RequestParam Long sessionId) {
        return quizService.getRandomQuestion(sessionId);
    }

    @PostMapping("/submit")
    public SubmitAnswerResponse submitAnswer(
            @RequestParam Long sessionId,
            @RequestParam Long questionId,
            @RequestParam String answer) {
        return quizService.submitAnswer(sessionId, questionId, answer);
    }

    @GetMapping("/summary")
    public QuizSummaryResponse getSummary(@RequestParam Long sessionId) {
        return quizService.getSummary(sessionId);
    }


}
