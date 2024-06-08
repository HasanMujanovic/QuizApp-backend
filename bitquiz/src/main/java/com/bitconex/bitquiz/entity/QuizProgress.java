package com.bitconex.bitquiz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "quiz_progress")
@Getter
@Setter
public class QuizProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "points")
    private int points;

    @Column(name = "time")
    private int time;

    @Column(name = "questions_answered")
    private int questionsAnswered;

    @Column(name = "time_of_saving")
    @UpdateTimestamp
    private Date timeOfSaving;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userSaved;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quizSaved;
}
