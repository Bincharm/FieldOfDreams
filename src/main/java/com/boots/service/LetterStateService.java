package com.boots.service;

import com.boots.entity.LetterState;
import com.boots.model.ReportWordModel;
import com.boots.repository.LetterStateRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LetterStateService {

    LetterStateRepository letterStateRepository;

    public LetterState saveLetterState(LetterState letterState){
        return letterStateRepository.save(letterState);
    }

    public List<LetterState> findAllGameAttemptsByGameId(Long gameId){
        return letterStateRepository.findAllByGame_IdOrderByTryTimeAsc(gameId);
    }

}
