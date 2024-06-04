package com.bitconex.bitquiz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "kviz_pitanja")
@Getter
@Setter
public class KvizPitanja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "tekst")
    private String tekst;


    @ManyToOne
    @JoinColumn(name = "kviz_id")
    private Kviz kviz;

    @OneToMany(mappedBy = "pitanja", cascade = CascadeType.ALL)
    private List<KvizOdgovori> odgovori = new ArrayList<>();

    public void add(KvizOdgovori[] kvizOdgovori){
        if (kvizOdgovori != null) {
            if (odgovori == null) {
                odgovori = new ArrayList<>();
            }
            for (KvizOdgovori value : kvizOdgovori) {
                odgovori.add(value);
                value.setPitanja(this);

            }
        }
    }
}
