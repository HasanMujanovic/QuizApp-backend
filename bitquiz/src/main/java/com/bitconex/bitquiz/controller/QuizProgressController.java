package com.bitconex.bitquiz.controller;


import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.AddQuizProgressDto;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.request.AddQuizProgressRequest;
import com.bitconex.bitquiz.services.SaveProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bit/quiz-progress")
public class QuizProgressController {
    @Autowired
    private SaveProgressService saveProgressService;

    @PostMapping("/make")
    public void saveQuizProgress(@RequestBody AddQuizProgressRequest addQuizProgressRequest){
        AddQuizProgressDto addQuizProgressDto = AddQuizProgressDto.requestToDto(addQuizProgressRequest);
        saveProgressService.saveProgress(addQuizProgressDto);
    }
}
