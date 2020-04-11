package com.boots.service;

import com.boots.entity.Game;
import com.boots.entity.LetterState;
import com.boots.entity.Word;
import com.boots.model.LetterCheckModel;
import com.boots.model.WordCheckResponseModel;
import com.boots.repository.WordRepository;
import com.boots.repository.dao.LetterStateDao;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WordService {

    @PersistenceContext
    private EntityManager em;

    WordRepository wordRepository;
    LetterStateService letterStateService;

    public List<Word> allWords(){
//        System.err.println(letterStateDao.getLastTry(1L));
        return wordRepository.findAll();
    }

    public Word getRandomWord(){
        Random rand = new Random();
        return wordRepository.findAll().get(rand.nextInt(wordRepository.findAll().size()));
    }

    public boolean saveWord(Word word) {
        Word wordFromDB = wordRepository.findByWord(word.getWord());

        if (wordFromDB != null) {
            return false;
        }

//        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        wordRepository.save(word);
        return true;
    }

    public boolean deleteWord(Long wordId) {
        if (wordRepository.findById(wordId).isPresent()) {
            wordRepository.deleteById(wordId);
            return true;
        }
        return false;
    }

    public List<Word> wordgtList(Long idMin) {
        return em.createQuery("SELECT w FROM Word w WHERE w.id > :paramId", Word.class)
                .setParameter("paramId", idMin).getResultList();
    }

    public List<Integer> isLetterCorrect(LetterCheckModel letterCheckModel){

        Optional<Word> wordOptional = wordRepository.findById(letterCheckModel.getWordId());

        if(!wordOptional.isPresent()) throw new RuntimeException("No such word found"); //TODO create custom exception

        Word word = wordOptional.get();
        String wordFromDB = word.getWord().toLowerCase();

        List<Integer> letterPositions = new ArrayList<>();
        for(int i = 0; i < wordFromDB.length(); i++){
            char c = wordFromDB.charAt(i);
            if(letterCheckModel.getLetter().equals(c + "")) {
                letterPositions.add(i);
            }
        }

        Game game = new Game();
        game.setId(letterCheckModel.getGameId());

        LetterState letterState = new LetterState();
        letterState.setGame(game);
        letterState.setLetter(letterCheckModel.getLetter());
        letterState.setIsCorrect(letterPositions.size() > 0);
        letterStateService.saveLetterState(letterState);

        return letterPositions;
    }

    public WordCheckResponseModel isWordCorrect(LetterCheckModel letterCheckModel){

        Optional<Word> wordOptional = wordRepository.findById(letterCheckModel.getWordId());

        if(!wordOptional.isPresent()) throw new RuntimeException("No such word found"); //TODO create custom exception

        Word wordFromDB = wordOptional.get();

        WordCheckResponseModel response = new WordCheckResponseModel();

        response.setWordFromDB(wordFromDB.getWord());
        response.setIsWin(wordFromDB.getWord().toLowerCase().equals(letterCheckModel.getLetter()));

        Game game = new Game();
        game.setId(letterCheckModel.getGameId());

        LetterState letterState = new LetterState();
        letterState.setGame(game);
        letterState.setLetter(letterCheckModel.getLetter());
        letterState.setIsCorrect(response.getIsWin());
        letterStateService.saveLetterState(letterState);

        return response;
    }


}
