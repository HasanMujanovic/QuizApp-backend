package com.bitconex.bitquiz.controller;


import com.bitconex.bitquiz.dto.KvizProgresDto;
import com.bitconex.bitquiz.services.SacuvajProgresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bit/kviz-progres")
public class DodajKvizProgresController {
    @Autowired
    private SacuvajProgresService sacuvajProgresService;

    @PostMapping("/napravi")
    public void napraviKviz(@RequestBody KvizProgresDto kvizProgresDto){
        sacuvajProgresService.sacuvajProgres(kvizProgresDto);
    }
}
