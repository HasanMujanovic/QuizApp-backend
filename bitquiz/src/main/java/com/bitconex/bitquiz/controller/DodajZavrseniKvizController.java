package com.bitconex.bitquiz.controller;

import com.bitconex.bitquiz.dto.ZavrsenKvizDto;
import com.bitconex.bitquiz.services.DodajZavrsenKvizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bit/zavrseni-kviz")
public class DodajZavrseniKvizController {
    @Autowired
    private DodajZavrsenKvizService dodajZavrsenKvizService;

    @PostMapping("/napravi")
    public void napraviKviz(@RequestBody ZavrsenKvizDto zavrsenKvizDto){
        dodajZavrsenKvizService.dodajZavrsenKviz(zavrsenKvizDto);
    }
}
