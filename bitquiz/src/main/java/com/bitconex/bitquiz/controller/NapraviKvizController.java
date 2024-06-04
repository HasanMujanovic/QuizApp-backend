package com.bitconex.bitquiz.controller;

import com.bitconex.bitquiz.dto.NapraviKvizDTO;
import com.bitconex.bitquiz.services.NapraviKvizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bit/napravi-kviz")
public class NapraviKvizController {
    @Autowired
    private NapraviKvizService napraviKvizService;

    @PostMapping("/napravi")
    public void napraviKviz(@RequestBody NapraviKvizDTO napraviKvizDTO){
        napraviKvizService.napraviKviz(napraviKvizDTO);
    }

}
