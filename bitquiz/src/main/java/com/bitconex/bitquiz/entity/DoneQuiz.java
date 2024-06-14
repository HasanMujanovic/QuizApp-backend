package com.bitconex.bitquiz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "done_quiz")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DoneQuiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "points_won")
    private int pointsWon;

    @Column(name = "time_left")
    private int timeLeft;


    @Column(name = "user_id_for_search")
    private int userIdForSearch;

    @Column(name = "quiz_id_for_search")
    private int quizIdForSearch;

    @Column(name = "username")
    private String username;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User userEnd;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    @JsonIgnore
    private Quiz quizEnd;

}
