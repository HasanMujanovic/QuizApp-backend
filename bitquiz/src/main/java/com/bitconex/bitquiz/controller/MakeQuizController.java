package com.bitconex.bitquiz.controller;

import com.bitconex.bitquiz.dto.MakeQuizDto;
import com.bitconex.bitquiz.services.MakeNewQuiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bit/make-quiz")
public class MakeQuizController {
    @Autowired
    private MakeNewQuiz makeNewQuiz;

    @PostMapping("/make")
    public void makeQuiz(@RequestBody MakeQuizDto makeQuizDto){
        makeNewQuiz.makeQuiz(makeQuizDto);
    }

}