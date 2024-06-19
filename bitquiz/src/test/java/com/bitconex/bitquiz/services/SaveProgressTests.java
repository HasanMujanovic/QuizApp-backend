package com.bitconex.bitquiz.services;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.AddQuizProgressDto;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizProgressDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.usersDTO.UserDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Port.mappers.toEntity.QuizProgressMapper;
import com.bitconex.bitquiz.entity.QuizProgress;
import com.bitconex.bitquiz.entity.User;
import com.bitconex.bitquiz.repository.QuizProgressRepo;
import com.bitconex.bitquiz.repository.UserRepo;
import com.bitconex.bitquiz.services.impl.SaveProgressServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SaveProgressTests {

    @Mock
    private UserRepo userRepo;

    @Mock
    private QuizProgressRepo quizProgressRepo;

    @Mock
    private QuizProgressMapper quizProgressMapper;

    @InjectMocks
    private SaveProgressServiceImpl saveProgressService;

    private User user;
    private UserDTO userDTO;
    private QuizProgressDTO quizProgressDTO;
    private AddQuizProgressDto addQuizProgressDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user = User.builder().id(1).email("test@example.com").password("password").status("active").build();
        userDTO = UserDTO.builder().email("test@example.com").build();

        quizProgressDTO = new QuizProgressDTO();
        quizProgressDTO.setId(1);
        quizProgressDTO.setQuizId(1);
        quizProgressDTO.setPoints(100);
        quizProgressDTO.setTime(120);
        quizProgressDTO.setQuestionsAnswered(10);
        quizProgressDTO.setCorrectAns(2);
        quizProgressDTO.setWrongAns(6);
        quizProgressDTO.setSkippedAns(2);

        addQuizProgressDto = new AddQuizProgressDto();
        addQuizProgressDto.setQuizProgress(quizProgressDTO);
        addQuizProgressDto.setUser(userDTO);

    }

    @Test
    void testSaveProgress() {
        // Arrange
        when(userRepo.findByEmail(anyString())).thenReturn(Optional.of(user));
        when(quizProgressMapper.apply(quizProgressDTO)).thenReturn(new QuizProgress());
        when(quizProgressRepo.findByUserSavedAndQuizId(any(User.class), anyInt())).thenReturn(Optional.empty());

        // Act
        saveProgressService.saveProgress(addQuizProgressDto);

        // Assert
        verify(userRepo).findByEmail("test@example.com");
        verify(quizProgressRepo).save(any(QuizProgress.class));
    }
}
