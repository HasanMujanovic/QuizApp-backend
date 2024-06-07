package com.bitconex.bitquiz.dto;

import com.bitconex.bitquiz.entity.Kviz;
import com.bitconex.bitquiz.entity.User;
import com.bitconex.bitquiz.entity.ZavrsenKviz;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ZavrsenKvizDto {
    User user;
    Kviz kviz;
    ZavrsenKviz zavrsenKviz;
}
