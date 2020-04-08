package com.boots.service;

import com.boots.entity.LetterState;
import com.boots.repository.LetterStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LetterStateService {

    @Autowired
    LetterStateRepository letterStateRepository;

    public LetterState saveLetterState(LetterState letterState){
        return letterStateRepository.save(letterState);
    }

}
