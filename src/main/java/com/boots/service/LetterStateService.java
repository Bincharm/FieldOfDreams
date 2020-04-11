package com.boots.service;

import com.boots.entity.LetterState;
import com.boots.model.ReportWordModel;
import com.boots.repository.LetterStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LetterStateService {

    @Autowired
    LetterStateRepository letterStateRepository;

    public LetterState saveLetterState(LetterState letterState){
        return letterStateRepository.save(letterState);
    }

    public List<LetterState> findAllGameAttemptsByGameId(Long gameId){
        return letterStateRepository.findAllByGame_IdOrderByTryTimeAsc(gameId);
    }

}
