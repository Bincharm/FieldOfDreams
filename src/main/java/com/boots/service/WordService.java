package com.boots.service;

import com.boots.entity.Word;
import com.boots.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class WordService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    WordRepository wordRepository;

    public List<Word> allWords(){
        return wordRepository.findAll();
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
}
