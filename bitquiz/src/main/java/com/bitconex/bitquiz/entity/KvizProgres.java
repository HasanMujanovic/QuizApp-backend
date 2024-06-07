package com.bitconex.bitquiz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "kviz_progres")
@Getter
@Setter
public class KvizProgres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "bodovi")
    private int bodovi;

    @Column(name = "vreme")
    private int vreme;

    @Column(name = "odgovorenih_pitanja")
    private int odgovorenihPitanja;

    @Column(name = "vreme_cuvanja")
    @UpdateTimestamp
    private Date vremeCuvanja;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userSaved;

    @ManyToOne
    @JoinColumn(name = "kviz_id")
    private Kviz kvizSaved;
}
