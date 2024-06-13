package com.bitconex.bitquiz.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "roles")
    private String roles;

    @Column(name = "level")
    private int level;

    @Column(name = "points")
    private int points;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Quiz> quizzes = new ArrayList<>();

    @OneToMany(mappedBy = "userEnd", cascade = CascadeType.ALL)
    private List<DoneQuiz> doneQuiz = new ArrayList<>();

    @OneToMany(mappedBy = "userSaved", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuizProgress> quizProgresses = new ArrayList<>();


    public void add(Quiz item){
        if (item != null){
            if(quizzes == null){
                quizzes = new ArrayList<>();
            }
            quizzes.add(item);
            item.setUser(this);
        }
    }

    public void addZavrsenKviz(DoneQuiz item){
        if (item != null){
            if(doneQuiz == null){
                doneQuiz = new ArrayList<>();
            }
            doneQuiz.add(item);
            item.setUserEnd(this);
        }
    }

    public void addSavedKviz(QuizProgress item){
        if (item != null){
            if(quizProgresses == null){
                quizProgresses = new ArrayList<>();
            }
            quizProgresses.add(item);
            item.setUserSaved(this);
        }
    }

    public void removeQuizProgress(QuizProgress quizProgress) {
        quizProgresses.remove(quizProgress);
        quizProgress.setUserSaved(null);
    }




}
