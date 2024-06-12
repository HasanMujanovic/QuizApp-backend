package com.bitconex.bitquiz.controller;

import com.bitconex.bitquiz.architecture.dto.quizDTO.QuizProgressDTO;
import com.bitconex.bitquiz.architecture.dto.quizDTO.QuizQuestionsDTO;
import com.bitconex.bitquiz.architecture.dto.quizDTO.QuizResponseDTO;
import com.bitconex.bitquiz.services.PlayingQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bit/playing")
public class PlayingQuizController {
    @Autowired
    private PlayingQuizService quizService;

    @GetMapping("/{quizId}/questions")
    public ResponseEntity<List<QuizQuestionsDTO>> getQuizQuestionsByQuizId(@PathVariable int quizId) {
        List<QuizQuestionsDTO> quizQuestionsDTOList = quizService.getQuizQuestionsByQuizId(quizId);
        return ResponseEntity.ok(quizQuestionsDTOList);
    }

    @GetMapping("/questions/{questionId}/responses")
    public ResponseEntity<List<QuizResponseDTO>> getQuizResponsesByQuestionId(@PathVariable long questionId) {
        List<QuizResponseDTO> quizResponseDTOList = quizService.getQuizResponsesByQuestionId(questionId);
        return ResponseEntity.ok(quizResponseDTOList);
    }

    @GetMapping("/users/{userId}/progress")
    public ResponseEntity<List<QuizProgressDTO>> getQuizProgressByUserId(@PathVariable int userId) {
        List<QuizProgressDTO> quizProgressDTOList = quizService.getQuizProgressByUserId(userId);
        return ResponseEntity.ok(quizProgressDTOList);
    }
}
