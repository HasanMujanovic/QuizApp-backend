package com.bitconex.bitquiz.services;

import com.bitconex.bitquiz.dao.ZavrsenKvizRepo;
import com.bitconex.bitquiz.dto.ZavrsenKvizDto;
import com.bitconex.bitquiz.entity.Kviz;
import com.bitconex.bitquiz.entity.User;
import com.bitconex.bitquiz.entity.ZavrsenKviz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DodajZavrsenKvizServiceImpl implements DodajZavrsenKvizService{
    @Autowired
    ZavrsenKvizRepo zavrsenKvizRepo;
    @Override
    public void dodajZavrsenKviz(ZavrsenKvizDto zavrsenKvizDto) {

        User user = zavrsenKvizDto.getUser();
        Kviz kviz = zavrsenKvizDto.getKviz();
        ZavrsenKviz zavrsenKviz = zavrsenKvizDto.getZavrsenKviz();
        user.addZavrsenKviz(zavrsenKviz);
        kviz.addZavrsenKviz(zavrsenKviz);

        zavrsenKvizRepo.save(zavrsenKviz);
    }
}
