package com.bitconex.bitquiz.services;


import com.bitconex.bitquiz.ErrorMessage.AppException;
import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.quizzesDTO.QuizDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Port.mappers.toDTO.QuizDTOMapper;
import com.bitconex.bitquiz.HexagonalArhitecture.Port.mappers.toDTO.UserDTOMapper;
import com.bitconex.bitquiz.HexagonalArhitecture.Port.mappers.toEntity.QuizMapper;
import com.bitconex.bitquiz.entity.Quiz;
import com.bitconex.bitquiz.repository.CategoryRepository;
import com.bitconex.bitquiz.repository.QuizRepo;
import com.bitconex.bitquiz.repository.UserRepo;
import com.bitconex.bitquiz.services.impl.QuizServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class QuizServiceTests {

    @Mock
    private UserRepo userRepo;

    @Mock
    private QuizRepo quizRepo;

    @Mock
    private QuizDTOMapper quizDTOMapper;

    @Mock
    private UserDTOMapper userDTOMapper;

    @Mock
    private QuizMapper quizMapper;

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private QuizServiceImpl quizService;

    private Quiz quiz;
    private QuizDTO quizDTO;

    @BeforeEach
    public void setUp() {
        quiz = new Quiz();
        quiz.setId(1);
        quiz.setName("Test Quiz");
        quiz.setCategory("Category1");
        quiz.setDifficulty("Easy");

        quizDTO = new QuizDTO();
        quizDTO.setId(1);
        quizDTO.setName("Test Quiz");
        quizDTO.setCategory("Category1");
        quizDTO.setDifficulty("Easy");
    }

    @Test
    public void testGetQuizById() {
        when(quizRepo.findById(1)).thenReturn(Optional.of(quiz));
        when(quizDTOMapper.apply(quiz)).thenReturn(quizDTO);

        QuizDTO result = quizService.getQuizById(1);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1);
        assertThat(result.getName()).isEqualTo("Test Quiz");
    }

    @Test
    public void testGetQuizByIdNotFound() {
        when(quizRepo.findById(1)).thenReturn(Optional.empty());

        assertThrows(AppException.class, () -> quizService.getQuizById(1));
    }

    @Test
    public void testGetAllQuiz() {
        List<Quiz> quizzes = Collections.singletonList(quiz);
        when(quizRepo.findAll()).thenReturn(quizzes);
        when(quizDTOMapper.apply(quiz)).thenReturn(quizDTO);

        List<QuizDTO> result = quizService.getAllQuiz();

        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getId()).isEqualTo(1);
    }

    @Test
    public void testEditQuiz() {
        when(quizRepo.findById(1)).thenReturn(Optional.of(quiz));

        quizDTO.setName("Updated Quiz");

        quizService.editQuiz(quizDTO);

        verify(quizRepo, times(1)).save(any(Quiz.class));
        assertThat(quiz.getName()).isEqualTo("Updated Quiz");
    }

    @Test
    public void testLikeingQuiz() {
        when(quizRepo.findById(1)).thenReturn(Optional.of(quiz));

        quizService.likeingQuiz(1);

        assertEquals(1, quiz.getLikes());

        verify(quizRepo, times(1)).save(quiz);
    }
}
