package com.bitconex.bitquiz.controller;

import com.bitconex.bitquiz.architecture.dto.quizDTO.QuizDTO;
import com.bitconex.bitquiz.architecture.response.QuizResponse;
import com.bitconex.bitquiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bit/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/getAll")
    public ResponseEntity<List<QuizResponse>> getAllQuizes(){
        List<QuizDTO> quizDTOList = quizService.getAllQuiz();
        return ResponseEntity.ok(quizDTOList.stream().map(QuizDTO::dtoToResponse).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizResponse> getQuizById(@PathVariable int id){
        QuizDTO quizDTO = quizService.getQuizById(id);
        return ResponseEntity.ok(QuizDTO.dtoToResponse(quizDTO));
    }
    @GetMapping("/{userId}/quizzes")
    public ResponseEntity<List<QuizResponse>> getQuizzesByUserId(@PathVariable int userId){
        List<QuizDTO> quizDTOList = quizService.getQuizesMadeByUser(userId);
        return ResponseEntity.ok(quizDTOList.stream().map(QuizDTO::dtoToResponse).collect(Collectors.toList()));
    }


}
