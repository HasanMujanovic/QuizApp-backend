package com.bitconex.bitquiz.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "quiz_progress")
@AllArgsConstructor
@NoArgsConstructor
@Data
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

    @Column(name = "quiz_id")
    private int quizId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userSaved;

}
