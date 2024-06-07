package com.bitconex.bitquiz.services;

import com.bitconex.bitquiz.dao.KvizProgresRepo;
import com.bitconex.bitquiz.dto.KvizProgresDto;
import com.bitconex.bitquiz.entity.Kviz;
import com.bitconex.bitquiz.entity.KvizProgres;
import com.bitconex.bitquiz.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SacuvajProgresServiceImpl implements SacuvajProgresService{
    @Autowired
    private KvizProgresRepo kvizProgresRepo;

    @Override
    public void sacuvajProgres(KvizProgresDto kvizProgresDto) {
        Kviz kviz = kvizProgresDto.getKviz();
        User user = kvizProgresDto.getUser();
        KvizProgres kvizProgres = kvizProgresDto.getKvizProgres();

        kviz.addSavedKviz(kvizProgres);
        user.addSavedKviz(kvizProgres);

        kvizProgresRepo.save(kvizProgres);

    }
}
