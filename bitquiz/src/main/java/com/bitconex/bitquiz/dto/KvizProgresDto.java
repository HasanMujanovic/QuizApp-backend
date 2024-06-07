package com.bitconex.bitquiz.dto;

import com.bitconex.bitquiz.entity.Kviz;
import com.bitconex.bitquiz.entity.KvizProgres;
import com.bitconex.bitquiz.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KvizProgresDto {
    Kviz kviz;
    User user;
    KvizProgres kvizProgres;


}
