package com.bitconex.bitquiz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "done_quiz")
@Getter
@Setter
public class DoneQuiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "points_won")
    private int pointsWon;

    @Column(name = "time_left")
    private int timeLeft;

    @Column(name = "date_of_finishing")
    @CreationTimestamp
    private Date dateOfFinishing;

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
