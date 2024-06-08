package com.bitconex.bitquiz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "quiz_questions")
@Getter
@Setter
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


    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @OneToMany(mappedBy = "questions", cascade = CascadeType.ALL)
    private List<QuizResponse> responses = new ArrayList<>();

    public void add(QuizResponse[] quizResponse){
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
