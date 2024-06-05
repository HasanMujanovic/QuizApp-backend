package com.bitconex.bitquiz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "kviz")
@Getter
@Setter
public class Kviz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "kategorija")
    private String kategorija;

    @Column(name = "status")
    private String status;

    @Column(name = "tezina")
    private String tezina;

    @Column(name = "ime")
    private String ime;

    @Column(name = "svidjanja")
    private int svidjanja;

    @Column(name = "zavrsili")
    private int zavrsili;

    @Column(name = "vreme")
    private int vreme;

    @Column(name = "bodovi")
    private int bodovi;

    @OneToMany(mappedBy = "kviz", cascade = CascadeType.ALL)
    private List<KvizPitanja> pitanja = new ArrayList<>();

    public void add(KvizPitanja item){
        if (item != null){
            if(pitanja == null){
                pitanja = new ArrayList<>();
            }
            pitanja.add(item);
            item.setKviz(this);
        }
    }

}
