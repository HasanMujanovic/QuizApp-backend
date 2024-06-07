package com.bitconex.bitquiz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Kviz> kvizovi = new ArrayList<>();

    @OneToMany(mappedBy = "userEnd", cascade = CascadeType.ALL)
    private List<ZavrsenKviz> zavrsenKviz = new ArrayList<>();

    @OneToMany(mappedBy = "userSaved", cascade = CascadeType.ALL)
    private List<KvizProgres> kvizProgres = new ArrayList<>();


    public void add(Kviz item){
        if (item != null){
            if(kvizovi == null){
                kvizovi = new ArrayList<>();
            }
            kvizovi.add(item);
            item.setUser(this);
        }
    }

    public void addZavrsenKviz(ZavrsenKviz item){
        if (item != null){
            if(zavrsenKviz == null){
                zavrsenKviz = new ArrayList<>();
            }
            zavrsenKviz.add(item);
            item.setUserEnd(this);
        }
    }

    public void addSavedKviz(KvizProgres item){
        if (item != null){
            if(kvizProgres == null){
                kvizProgres = new ArrayList<>();
            }
            kvizProgres.add(item);
            item.setUserSaved(this);
        }
    }




}
