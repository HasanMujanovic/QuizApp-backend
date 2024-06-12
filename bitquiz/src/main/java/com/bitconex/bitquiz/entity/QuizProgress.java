package com.bitconex.bitquiz.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name = "quiz_id")
    private int quizId;

    @Column(name = "cor_ans")
    private int correctAns;

    @Column(name = "wrong_ans")
    private int wrongAns;

    @Column(name = "skipped_ans")
    private int skippedAns;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userSaved;


}
