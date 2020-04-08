package com.boots.repository;

import com.boots.entity.Game;
import com.boots.entity.User;
import com.boots.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findByUserAndWord(User user, Word word);

    Game getFirstByUserAndWord(User user, Word word);
}
