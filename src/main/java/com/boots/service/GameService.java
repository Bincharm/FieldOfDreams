package com.boots.service;

import com.boots.entity.Game;
import com.boots.model.ReportUserModel;
import com.boots.repository.GameRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GameService {

    GameRepository gameRepository;

    public List<Game> findAll() {
        return gameRepository.findAll();
    }


    public Game saveGame(Game game) {
        //List<Game> gamesFromDB = gameRepository.findByUserAndWord(game.getUser(), game.getWord());
        Game gamesFromDB2 = gameRepository.getFirstByUserAndWord(game.getUser(), game.getWord());

        /*if (gamesFromDB.size() != 0) {
            return false;
        }*/

//        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        return gameRepository.save(game);
    }

    public boolean deleteGame(Long gameId) {
        if (gameRepository.findById(gameId).isPresent()) {
            gameRepository.deleteById(gameId);
            return true;
        }
        return false;
    }

    @Transactional
    public int saveTrueWinResult(Long gameId){
        //return gameRepository.updateIsWinTrueByGameIdNative(gameId);
        return gameRepository.updateIsWinTrueByGameId(gameId);
    }

    public List<ReportUserModel> findAllUsersGames(){
        return gameRepository.findAllUsersGames();
    }

    public List<ReportUserModel> findUserGamesByUserId(Long userId){
        return gameRepository.findUserGamesByUserId(userId);
    }

}
