package com.bitconex.bitquiz.controller;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.usersDTO.UserDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.response.quizzesResponse.QuizResponse;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.response.userResponse.UserResponse;
import com.bitconex.bitquiz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{quizId}/admin")
    public ResponseEntity<UserResponse> getAdminByQuizId(@PathVariable int quizId){
        UserDTO userDTO = quizService.getAdminByQuizId(quizId);
        return ResponseEntity.ok(UserDTO.dtoToResponse(userDTO));
    }

    @DeleteMapping("/{quizId}/user/{userId}/delete")
    public void deleteQuiz(@PathVariable int quizId, @PathVariable int userId){
        quizService.deleteQuiz(quizId,userId);
    }


    @PostMapping("/{quizId}/like")
    public void likeQuiz(@PathVariable int quizId){
        quizService.likeingQuiz(quizId);
    }

    @GetMapping("/filtered")
    public ResponseEntity<List<QuizResponse>> getFilteredQuizzes(
            @RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "difficulty", required = false) String difficulty) {
        List<QuizDTO> quizDTOList = quizService.filteredQuizes(category, difficulty);
        return ResponseEntity.ok(quizDTOList.stream().map(QuizDTO::dtoToResponse).collect(Collectors.toList()));
    }

}
