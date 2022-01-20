package com.appleindustries.mirror.controllers;

import com.appleindustries.mirror.services.MirrorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zane
 */
@RequestMapping("/mirror")
@AllArgsConstructor
@RestController
public class MirrorController {

    @Autowired
    MirrorService mirrorService;

    /**
     *
     * @param sentence to mirror
     * @return mirror service respone which will mirror sentence
     */
    @GetMapping("/{sentence}")
    public String mirrorSentence(@PathVariable String sentence) {
        return mirrorService.mirrorSentence(sentence);
    }

}
