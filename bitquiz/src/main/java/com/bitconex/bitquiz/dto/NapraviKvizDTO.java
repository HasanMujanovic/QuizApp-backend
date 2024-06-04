package com.bitconex.bitquiz.dto;

import com.bitconex.bitquiz.entity.Kviz;
import com.bitconex.bitquiz.entity.KvizOdgovori;
import com.bitconex.bitquiz.entity.KvizPitanja;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NapraviKvizDTO {
    Kviz kviz;
    List<KvizPitanja> kvizPitanja;
    List<KvizOdgovori[]> kvizOdgovori;
}
