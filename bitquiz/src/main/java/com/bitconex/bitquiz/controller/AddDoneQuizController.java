package com.bitconex.bitquiz.controller;

import com.bitconex.bitquiz.dto.DoneQuizDto;
import com.bitconex.bitquiz.services.AddDoneQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bit/done-quizes")
public class AddDoneQuizController {
    @Autowired
    private AddDoneQuizService addDoneQuizService;

    @PostMapping("/make")
    public void napraviKviz(@RequestBody DoneQuizDto doneQuizDto){
        addDoneQuizService.addDoneQuiz(doneQuizDto);
    }
}
