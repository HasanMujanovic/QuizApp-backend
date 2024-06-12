package com.bitconex.bitquiz.controller;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.AddDoneQuizDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.DoneQuizDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.request.AddDoneQuizRequest;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.response.AddDoneQuizResponse;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.response.quizzesResponse.DoneQuizResponse;
import com.bitconex.bitquiz.services.DoneQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bit/done-quizes")
public class DoneQuizController {
    @Autowired
    private DoneQuizService doneQuizService;

    @PostMapping("/make")
    public ResponseEntity<AddDoneQuizResponse> napraviKviz(@RequestBody AddDoneQuizRequest addDoneQuizRequest) {
        AddDoneQuizDTO addDoneQuizDTO = AddDoneQuizDTO.requestToDto(addDoneQuizRequest);

        doneQuizService.addDoneQuiz(addDoneQuizDTO);

        return ResponseEntity.ok(AddDoneQuizDTO.dtoToResponse(addDoneQuizDTO));
    }

    @GetMapping("/{quizId}/doneQuiz")
    public ResponseEntity<List<DoneQuizResponse>> getLeaderboardForQuiz(@PathVariable int quizId) {
        int limit = 5;
        List<DoneQuizDTO> leaderboard = doneQuizService.getSortedLeaderboard(quizId, limit);
        return ResponseEntity.ok(leaderboard.stream().map(DoneQuizDTO::dtoToResponse).collect(Collectors.toList()));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<DoneQuizResponse>> getDoneQuizzesByUserId(@PathVariable int userId) {
        List<DoneQuizDTO> doneQuizzes = doneQuizService.getDoneQuizzesByUserId(userId);
        return ResponseEntity.ok(doneQuizzes.stream().map(DoneQuizDTO::dtoToResponse).collect(Collectors.toList()));
    }
}
