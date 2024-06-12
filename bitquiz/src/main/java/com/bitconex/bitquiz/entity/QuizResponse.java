package com.bitconex.bitquiz.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "quiz_response")
@AllArgsConstructor
@NoArgsConstructor
@Data

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
