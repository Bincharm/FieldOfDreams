package com.boots.service;

import com.boots.model.ReportUserModel;
import com.boots.model.ReportWordModel;
import com.boots.repository.GameRepository;
import com.boots.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private UserService userService;



    @Autowired
    private LetterStateService letterStateService;

    public List<ReportUserModel> findAllUsersGames(){
        return gameRepository.findAllUsersGames();
    }

    public List<ReportUserModel> findUserGamesByCurrentUser(){
        return gameRepository.findUserGamesByUserId(userService.getCurrentUser().getId());
    }

    public List<ReportWordModel> findAllGameAttemptsByGameId(Long gameId){
        return letterStateService.findAllGameAttemptsByGameId(gameId).stream()
                .map(x -> ReportWordModel.builder()
                        .isCorrect(x.getCorrect())
                        .letter(x.getLetter())
                        .tryTime(x.getTryTime())
                        .build())
                .collect(Collectors.toList());
    }

}
