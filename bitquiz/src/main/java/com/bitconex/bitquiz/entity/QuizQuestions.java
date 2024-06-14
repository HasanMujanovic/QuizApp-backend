package com.bitconex.bitquiz.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "quiz_questions")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuizQuestions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "text")
    private String text;

    @Column(name = "points")
    private int points;

    @Column(name = "help_allowed")
    private boolean helpAllowed;

    @Column(name = "minus_points")
    private int minusPoints;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @OneToMany(mappedBy = "questions", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuizResponse> responses = new ArrayList<>();

    public void add(QuizResponse[] quizResponse) {
        if (quizResponse != null) {
            if (responses == null) {
                responses = new ArrayList<>();
            }
            for (QuizResponse value : quizResponse) {
                responses.add(value);
                value.setQuestions(this);
            }
        }
    }
}
