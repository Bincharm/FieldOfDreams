package com.boots.controller;

import com.boots.entity.Game;
import com.boots.entity.LetterState;
import com.boots.entity.Word;
import com.boots.model.LetterCheckModel;
import com.boots.model.WordCheckResponseModel;
import com.boots.service.GameService;
import com.boots.service.UserService;
import com.boots.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private UserService userService;

    @Autowired
    private WordService wordService;

    @GetMapping
    public String gameList(Model model) {
        model.addAttribute("allGames", gameService.findAll());
        return "game";
    }
    @GetMapping("/delete")
    public String deleteGame(@RequestParam(required = true, name = "gameId") Long gameId) {
        gameService.deleteGame(gameId);
        return "redirect:/game";
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

    @PostMapping
    public String saveGame(@ModelAttribute("gameForm") @Valid Game gameForm, BindingResult bindingResult, ModelMap model) {

        if (bindingResult.hasErrors()) {
            return "game";
        }

        Word randomWord = wordService.getRandomWord();
        gameForm.setUser(userService.getCurrentUser());
        gameForm.setWord(randomWord);

        Game game =gameService.saveGame(gameForm);
        if (game == null) {
            model.addAttribute("gameError", "Вы угадали все слова");
            return "game";
        }

        model.addAttribute("wordLength", randomWord.getWord().length());
        model.addAttribute("wordId", randomWord.getId());
        model.addAttribute("word", randomWord.getWord());
        model.addAttribute("gameId", game.getId());

//        model.addAttribute("words", new Word());

        return "game";
    }

    @PostMapping(value = "/gameOneLetter", produces = "application/json")
    public @ResponseBody List<Integer> saveLetter(@RequestBody LetterCheckModel letterCheckModel) {

        List<Integer> letterPositions = wordService.isLetterCorrect(letterCheckModel);
        return letterPositions;
    }

    @PostMapping(value = "/gameWholeWord", produces = "application/json")
    public @ResponseBody WordCheckResponseModel saveLetterWholeWord(@RequestBody LetterCheckModel letterCheckModel){

        WordCheckResponseModel wholeWord = wordService.isWordCorrect(letterCheckModel);
        return wholeWord;
    }

}
