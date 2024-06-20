package com.bitconex.bitquiz.Mockdata;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.MakeQuizDto;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizQuestionsDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizResponseDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.usersDTO.UserDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Port.mappers.toDTO.UserDTOMapper;
import com.bitconex.bitquiz.PasswordSecurity.RegisterDTO;
import com.bitconex.bitquiz.services.QuizService;
import com.bitconex.bitquiz.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MockDataConfig implements CommandLineRunner {
    private UserService userService;
    private UserDTOMapper userDTOMapper;
    private QuizService quizService;

    public MockDataConfig(UserService userService, UserDTOMapper userDTOMapper, QuizService quizService) {
        this.userService = userService;
        this.userDTOMapper = userDTOMapper;
        this.quizService = quizService;
    }

    @Override
    public void run(String... args) throws Exception {
       UserDTO userDTO = userService.register(new RegisterDTO(userDTOMapper
               .apply(UserMock.getMockUserAdmin()),"seto123"));
       UserDTO userDTO1 = userService.register(new RegisterDTO(userDTOMapper
               .apply(UserMock.getMockUserPlayer()),"yugi123"));

       QuizDTO quizDTO = QuizMock.getMockQuiz();
       List<QuizQuestionsDTO> quizQuestionsDTOS = QuizQuestionsMock.getQuizQuestions();
       List<QuizResponseDTO[]> quizResponseDTOS = QuizResponsesMock.getResponses();
       quizService.makeQuiz(new MakeQuizDto(userDTO,quizDTO,quizQuestionsDTOS,quizResponseDTOS));

       QuizDTO quizDTO1 = QuizMock.getMockQuiz2();
       List<QuizQuestionsDTO> quizQuestionsDTOS1 = QuizQuestionsMock.getQuziQuestions2();
       List<QuizResponseDTO[]> quizResponseDTOS1 = QuizResponsesMock.getResponses2();
       quizService.makeQuiz(new MakeQuizDto(userDTO,quizDTO1,quizQuestionsDTOS1,quizResponseDTOS1));
    }
}
