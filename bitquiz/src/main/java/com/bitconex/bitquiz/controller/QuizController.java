package com.bitconex.bitquiz.controller;

import com.bitconex.bitquiz.dto.QuizDTO;
import com.bitconex.bitquiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bit/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/getAll")
    public ResponseEntity<List<QuizDTO>> getAllQuizes(){
        List<QuizDTO> quizDTOList = quizService.getAllQuiz();
        return ResponseEntity.ok(quizDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizDTO> getQuizById(@PathVariable int id){
        QuizDTO quizDTO = quizService.getQuizById(id);
        return ResponseEntity.ok(quizDTO);
    }
    @GetMapping("/{userId}/quizzes")
    public ResponseEntity<List<QuizDTO>> getQuizzesByUserId(@PathVariable int userId){
        List<QuizDTO> quizDTOList = quizService.getQuizesMadeByUser(userId);
        return ResponseEntity.ok(quizDTOList);
    }


}
