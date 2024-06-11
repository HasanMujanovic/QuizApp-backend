package com.bitconex.bitquiz.controller;

import com.bitconex.bitquiz.dto.AddDoneQuizDTO;
import com.bitconex.bitquiz.entity.DoneQuiz;
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
    public List<DoneQuiz> getLeaderboardForQuiz(@PathVariable int quizId) {
        int limit = 2;
        return doneQuizService.getSortedLeaderboard(quizId, limit);
    }
}
