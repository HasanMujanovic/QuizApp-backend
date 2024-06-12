package com.bitconex.bitquiz.controller;

import com.bitconex.bitquiz.dto.MakeQuizDto;
import com.bitconex.bitquiz.dto.QuizDTO;
import com.bitconex.bitquiz.services.DoneQuizService;
import com.bitconex.bitquiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bit/make-quiz")
public class MakeQuizController {
    private QuizService quizService;
    private DoneQuizService doneQuizService;

    @Autowired
    public MakeQuizController(QuizService quizService, DoneQuizService doneQuizService) {
        this.quizService = quizService;
        this.doneQuizService = doneQuizService;
    }

    @PostMapping("/make")
    public void makeQuiz(@RequestBody MakeQuizDto makeQuizDto){
        quizService.makeQuiz(makeQuizDto);
    }

    @PostMapping("/edit")
    public void editQuiz(@RequestBody QuizDTO quizDTO){
        quizService.editQuiz(quizDTO);
    }




}
