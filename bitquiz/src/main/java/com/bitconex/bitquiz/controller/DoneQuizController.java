package com.bitconex.bitquiz.controller;

import com.bitconex.bitquiz.architecture.dto.AddDoneQuizDTO;
import com.bitconex.bitquiz.architecture.dto.quizDTO.DoneQuizDTO;
import com.bitconex.bitquiz.services.DoneQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bit/done-quizes")
public class DoneQuizController {
    @Autowired
    private DoneQuizService doneQuizService;

    @PostMapping("/make")
    public ResponseEntity<AddDoneQuizDTO> napraviKviz(@RequestBody AddDoneQuizDTO addDoneQuizDTO) {
        doneQuizService.addDoneQuiz(addDoneQuizDTO);
        return new ResponseEntity<>(addDoneQuizDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{quizId}/doneQuiz")
    public ResponseEntity<List<DoneQuizDTO>> getLeaderboardForQuiz(@PathVariable int quizId) {
        int limit = 5;
        List<DoneQuizDTO> leaderboard = doneQuizService.getSortedLeaderboard(quizId, limit);
        return ResponseEntity.ok(leaderboard);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<DoneQuizDTO>> getDoneQuizzesByUserId(@PathVariable int userId) {
        List<DoneQuizDTO> doneQuizzes = doneQuizService.getDoneQuizzesByUserId(userId);
        return ResponseEntity.ok(doneQuizzes);
    }
}
