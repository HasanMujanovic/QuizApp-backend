package com.bitconex.bitquiz.services;

import com.bitconex.bitquiz.dao.UserRepo;
import com.bitconex.bitquiz.dto.NapraviKvizDTO;
import com.bitconex.bitquiz.entity.Kviz;
import com.bitconex.bitquiz.entity.KvizOdgovori;
import com.bitconex.bitquiz.entity.KvizPitanja;
import com.bitconex.bitquiz.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class NapraviKvizServiceImpl implements NapraviKvizService{

    @Autowired
    UserRepo userRepo;


    @Override
    public void napraviKviz(NapraviKvizDTO napraviKvizDTO) {
        Kviz kviz = napraviKvizDTO.getKviz();
        User user = napraviKvizDTO.getUser();

        List<KvizPitanja> kvizPitanja = new ArrayList<>();
        List<KvizOdgovori[]> kvizOdgovori = new ArrayList<>();

        kvizPitanja = napraviKvizDTO.getKvizPitanja();
        kvizOdgovori = napraviKvizDTO.getKvizOdgovori();

        for (int i = 0; i<kvizPitanja.size();i++){
            kvizPitanja.get(i).add(kvizOdgovori.get(i));
        }

        kvizPitanja.forEach(kviz::add);

        user.add(kviz);

        userRepo.save(user);

    }
}
