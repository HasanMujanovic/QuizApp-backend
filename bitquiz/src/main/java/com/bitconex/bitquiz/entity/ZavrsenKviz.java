package com.bitconex.bitquiz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "zavrsen_kviz")
@Getter
@Setter
public class ZavrsenKviz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "osvojeni_bodovi")
    private int osvojeniBodovi;

    @Column(name = "preostalo_vreme")
    private int preostaloVreme;

    @Column(name = "datum_zavrsetka")
    @CreationTimestamp
    private Date datumZavrsetka;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userEnd;

    @ManyToOne
    @JoinColumn(name = "kviz_id")
    private Kviz kvizEnd;





}
