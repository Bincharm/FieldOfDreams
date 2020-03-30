package com.boots.controller;

import com.boots.entity.Word;
import com.boots.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class WordController {

    @Autowired
    private WordService wordService;

    @GetMapping("/words")
    public String wordList(Model model){
        model.addAttribute("allWords", wordService.allWords());
        return "words";
    }

    @GetMapping("/words/delete")
    public String  deleteWord(@RequestParam(required = true, name = "wordId" ) Long wordId) {
        wordService.deleteWord(wordId);
        return "redirect:/words";
    }

//    @PostMapping("/words")
//    public String saveWord(@Valid @ModelAttribute("word")Word word, BindingResult result, ModelMap model){
//        if(result.hasErrors()){
//            return "error";
//        }
//        model.addAttribute("word", word.getWord());
//        wordService.saveWord(word);
//        return "words";
//    }

//    @PostMapping("/words")
//    public String  saveWord(@RequestParam(required = true, defaultValue = "" ) String word,
//                              @RequestParam(required = true, defaultValue = "" ) String action,
//                              Model model) {
//        if (action.equals("save")){
//            wordService.saveWord(new Word(word));
//        }
//        return "redirect:/words";
//    }

    @PostMapping("/words")
    public String saveWord(@ModelAttribute("wordForm") @Valid Word wordForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "words";
        }

        if (!wordService.saveWord(wordForm)){
            model.addAttribute("wordError", "Такое слово уже существует");
            return "words";
        }

//        model.addAttribute("words", new Word());

        return "redirect:/words";
    }

}
