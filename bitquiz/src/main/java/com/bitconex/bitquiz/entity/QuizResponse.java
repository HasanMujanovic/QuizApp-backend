package com.bitconex.bitquiz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "quiz_response")
@Getter
@Setter
public class QuizResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "text")
    private String text;

    @Column(name = "response_true")
    private boolean correctAnswer;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private QuizQuestions questions;
}
