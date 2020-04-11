package com.boots.controller;

import com.boots.entity.Word;
import com.boots.service.WordService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WordController {

    WordService wordService;

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

    @PostMapping("/words")
    public String saveWord(@ModelAttribute("wordForm") @Valid Word wordForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "words";
        }

        if (!wordService.saveWord(wordForm)){
            model.addAttribute("wordError", "Такое слово уже существует");
            return "words";
        }


        return "redirect:/words";
    }

}
