package com.bitconex.bitquiz.controller;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizProgressDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizQuestionsDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizResponseDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.response.QuizProgressResponse;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.response.QuizQuestionsResponse;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.response.QuziResponsessResponse;
import com.bitconex.bitquiz.services.PlayingQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bit/playing")
public class PlayingQuizController {
    @Autowired
    private PlayingQuizService quizService;

    @GetMapping("/{quizId}/questions")
    public ResponseEntity<List<QuizQuestionsResponse>> getQuizQuestionsByQuizId(@PathVariable int quizId) {
        List<QuizQuestionsDTO> quizQuestionsDTOList = quizService.getQuizQuestionsByQuizId(quizId);
        return ResponseEntity.ok(quizQuestionsDTOList.stream().map(QuizQuestionsDTO::dtoToResponse).collect(Collectors.toList()));
    }

    @GetMapping("/questions/{questionId}/responses")
    public ResponseEntity<List<QuziResponsessResponse>> getQuizResponsesByQuestionId(@PathVariable long questionId) {
        List<QuizResponseDTO> quizResponseDTOList = quizService.getQuizResponsesByQuestionId(questionId);
        return ResponseEntity.ok(quizResponseDTOList.stream().map(QuizResponseDTO::dtoToResponse).collect(Collectors.toList()));
    }

    @GetMapping("/users/{userId}/progress")
    public ResponseEntity<List<QuizProgressResponse>> getQuizProgressByUserId(@PathVariable int userId) {
        List<QuizProgressDTO> quizProgressDTOList = quizService.getQuizProgressByUserId(userId);
        return ResponseEntity.ok(quizProgressDTOList.stream().map(QuizProgressDTO::dtoToResponse).collect(Collectors.toList()));
    }
}
