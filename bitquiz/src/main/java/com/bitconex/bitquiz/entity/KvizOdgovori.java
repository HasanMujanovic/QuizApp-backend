package com.bitconex.bitquiz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "kviz_odgovori")
@Getter
@Setter
public class KvizOdgovori {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "tekst")
    private String tekst;

    @Column(name = "odgovor_tacan")
    private String odgovorTacan;

    @ManyToOne
    @JoinColumn(name = "pitanja_id")
    private KvizPitanja pitanja;
}