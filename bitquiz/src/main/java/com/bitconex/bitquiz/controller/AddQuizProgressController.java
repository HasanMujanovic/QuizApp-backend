package com.bitconex.bitquiz.controller;


import com.bitconex.bitquiz.dto.QuizProgressDto;
import com.bitconex.bitquiz.services.SaveProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bit/quiz-progress")
public class AddQuizProgressController {
    @Autowired
    private SaveProgressService saveProgressService;

    @PostMapping("/make")
    public void saveQuizProgress(@RequestBody QuizProgressDto quizProgressDto){
        saveProgressService.saveProgress(quizProgressDto);
    }
}
