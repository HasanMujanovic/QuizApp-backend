package com.bitconex.bitquiz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "quiz")
@Getter
@Setter
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "category")
    private String category;

    @Column(name = "status")
    private String status;

    @Column(name = "difficulty")
    private String difficulty;

    @Column(name = "username")
    private String name;

    @Column(name = "likes")
    private int likes;

    @Column(name = "done_it")
    private int doneIt;

    @Column(name = "time")
    private int time;

    @Column(name = "points")
    private int points;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<QuizQuestions> questions = new ArrayList<>();

    @OneToMany(mappedBy = "quizEnd", cascade = CascadeType.ALL)
    private List<DoneQuiz> doneQuiz = new ArrayList<>();

    @OneToMany(mappedBy = "quizSaved", cascade = CascadeType.ALL)
    private List<QuizProgress> quizProgress = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public void add(QuizQuestions item){
        if (item != null){
            if(questions == null){
                questions = new ArrayList<>();
            }
            questions.add(item);
            item.setQuiz(this);
        }
    }

    public void addZavrsenKviz(DoneQuiz item){
        if (item != null){
            if(doneQuiz == null){
                doneQuiz = new ArrayList<>();
            }
            doneQuiz.add(item);
            item.setQuizEnd(this);
        }
    }

    public void addSavedKviz(QuizProgress item){
        if (item != null){
            if(quizProgress == null){
                quizProgress = new ArrayList<>();
            }
            quizProgress.add(item);
            item.setQuizSaved(this);
        }
    }


}
