package com.boots.service;

import com.boots.model.ReportUserModel;
import com.boots.model.ReportWordModel;
import com.boots.repository.GameRepository;
import com.boots.repository.ReportRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReportService {

    @PersistenceContext
    private EntityManager em;

    GameService gameService;

    UserService userService;

    LetterStateService letterStateService;

    public List<ReportUserModel> findAllUsersGames(){
        return gameService.findAllUsersGames();
    }

    public List<ReportUserModel> findUserGamesByCurrentUser(){
        return gameService.findUserGamesByUserId(userService.getCurrentUser().getId());
    }

    public List<ReportWordModel> findAllGameAttemptsByGameId(Long gameId){
        return letterStateService.findAllGameAttemptsByGameId(gameId).stream()
                .map(x -> ReportWordModel.builder()
                        .isCorrect(x.getIsCorrect())
                        .letter(x.getLetter())
                        .tryTime(x.getTryTime())
                        .build())
                .collect(Collectors.toList());
    }

}
