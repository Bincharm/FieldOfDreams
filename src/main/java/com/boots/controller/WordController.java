package com.boots.controller;

import com.boots.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WordController {

    @Autowired
    private WordService wordService;

    @GetMapping("/words")
    public String wordList(Model model){
        model.addAttribute("allWords", wordService.allWords());
        return "admin/words";
    }

    @PostMapping("/words")
    public String  deleteWord(@RequestParam(required = true, defaultValue = "" ) Long wordId,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("delete")){
            wordService.deleteWord(wordId);
        }
        return "redirect:/words";
    }

}
