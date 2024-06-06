package com.bitconex.bitquiz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "ime")
    private String ime;

    @Column(name = "email")
    private String email;

    @Column(name = "sifra")
    private String sifra;

    @Column(name = "roles")
    private String roles;

    @Column(name = "nivo")
    private int nivo;

    @Column(name = "bodovi")
    private int bodovi;





}
