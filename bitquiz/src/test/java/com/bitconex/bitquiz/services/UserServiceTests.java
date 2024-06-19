package com.bitconex.bitquiz.services;

import com.bitconex.bitquiz.HexagonalArhitecture.Adapter.RequestResponseMapper.usersDTO.UserDTO;
import com.bitconex.bitquiz.HexagonalArhitecture.Port.mappers.toDTO.UserDTOMapper;
import com.bitconex.bitquiz.HexagonalArhitecture.Port.mappers.toEntity.UserMapper;
import com.bitconex.bitquiz.PasswordSecurity.CredentialsDTO;
import com.bitconex.bitquiz.PasswordSecurity.RegisterDTO;
import com.bitconex.bitquiz.entity.User;
import com.bitconex.bitquiz.repository.UserRepo;
import com.bitconex.bitquiz.services.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {
    @Mock
    private UserRepo userRepo;

    @Mock
    private UserDTOMapper userDTOMapper;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;
    private UserDTO userDTO;
    private CredentialsDTO credentialsDTO;
    private RegisterDTO registerDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user = User.builder().id(1).email("test@example.com").password("password").status("active").build();
        userDTO = UserDTO.builder().email("test@example.com").build();
        credentialsDTO = new CredentialsDTO("test@example.com", "password");
        registerDTO = new RegisterDTO(userDTO, "password");
    }

    @Test
    void testGetUser() {
        // Arrange
        when(userRepo.findByEmail(anyString())).thenReturn(Optional.of(user));
        when(userDTOMapper.apply(any(User.class))).thenReturn(userDTO);

        // Act
        UserDTO result = userService.getUser("test@example.com");

        // Assert
        assertThat(result).isEqualTo(userDTO);
        verify(userRepo).findByEmail("test@example.com");
        verify(userDTOMapper).apply(user);
    }

    @Test
    void testGetUserById() {
        // Arrange
        when(userRepo.findById(anyInt())).thenReturn(Optional.of(user));
        when(userDTOMapper.apply(any(User.class))).thenReturn(userDTO);

        // Act
        UserDTO result = userService.getUserById(1);

        // Assert
        assertThat(result).isEqualTo(userDTO);
        verify(userRepo).findById(1);
        verify(userDTOMapper).apply(user);
    }

    @Test
    void testSaveUserStatus(){
        // Arrange
        String newStatus = "inactive";
        when(userRepo.findByEmail(anyString())).thenReturn(Optional.of(user));

        // Act
        userService.saveUserStatus(newStatus, "test@example.com");

        // Assert
        assertThat(user.getStatus()).isEqualTo(newStatus);
        verify(userRepo).findByEmail("test@example.com");
        verify(userRepo).save(user);
    }

    @Test
    void testGetTop5UsersSortedByLevelAndPoints() {
        List<User> users = IntStream.range(0, 5)
                .mapToObj(i -> User.builder()
                        .id(i)
                        .email("user" + i + "@example.com")
                        .level(5 - i)
                        .points(100 - i)
                        .build())
                .collect(Collectors.toList());

        List<UserDTO>  userDTOs = users.stream()
                .map(user -> UserDTO.builder()
                        .email(user.getEmail())
                        .level(user.getLevel())
                        .points(user.getPoints())
                        .build())
                .collect(Collectors.toList());
        // Arrange
        when(userRepo.findByOrderByLevelDescPointsDesc(PageRequest.of(0, 5))).thenReturn(users);
        for (int i = 0; i < users.size(); i++) {
            when(userDTOMapper.apply(users.get(i))).thenReturn(userDTOs.get(i));
        }

        // Act
        List<UserDTO> result = userService.getTop5UsersSortedByLevelAndPoints();

        // Assert
        assertThat(result).hasSize(5);
        assertThat(result).isEqualTo(userDTOs);

        verify(userRepo).findByOrderByLevelDescPointsDesc(PageRequest.of(0, 5));
        for (int i = 0; i < users.size(); i++) {
            verify(userDTOMapper).apply(users.get(i));
        }
    }

    @Test
    void testRegister() {
        // Arrange
        when(userRepo.findByEmail(anyString())).thenReturn(Optional.empty());
        when(userMapper.apply(any(UserDTO.class))).thenReturn(user);
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        when(userRepo.save(any(User.class))).thenReturn(user);
        when(userDTOMapper.apply(any(User.class))).thenReturn(userDTO);

        // Act
        UserDTO result = userService.register(registerDTO);

        // Assert
        assertThat(result).isEqualTo(userDTO);
        verify(userRepo).findByEmail("test@example.com");
        verify(userMapper).apply(userDTO);
        verify(passwordEncoder).encode("password");
        verify(userRepo).save(user);
        verify(userDTOMapper).apply(user);
    }

}
