package com.boots.service;

import com.boots.entity.Game;
import com.boots.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class GameService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
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

    public List<Game> wordgtList(Long gameId) {
        return em.createQuery("SELECT g FROM Game g WHERE g.id > :paramId", Game.class)
                .setParameter("paramId", gameId).getResultList();
    }

}
