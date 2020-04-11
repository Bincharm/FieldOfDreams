package com.boots.repository;

import com.boots.entity.Game;
import com.boots.entity.User;
import com.boots.entity.Word;
import com.boots.model.ReportUserModel;
import com.boots.model.ReportWordModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findByUserAndWord(User user, Word word);

    Game getFirstByUserAndWord(User user, Word word);

//    @Query(value = "select u.username, g.id, w.word, g.creation_time, g.is_win  \n" +
//            "from t_game g\n" +
//            "join t_user u on u.id = g.user_id\n" +
//            "join t_word w on w.id = g.word_id \n" +
//            "order by g.id",
//            nativeQuery = true)
//    List<ReportUserModel> findAllUsersGamesNative();
    @Query(value = "select new com.boots.model.ReportUserModel(u.username, g.id, w.word, g.creationTime, g.isWin)  \n" +
            "from Game g \n" +
            "join g.user u \n" +
            "join g.word w \n" +
            "order by g.id")
    List<ReportUserModel> findAllUsersGames();

    @Query(value = "select new com.boots.model.ReportUserModel(g.id, w.word, g.creationTime, g.isWin)  \n" +
            "from Game g \n" +
            "join g.word w \n" +
            "where g.user.id = :user_id \n" +
            "order by g.id")
    List<ReportUserModel> findUserGamesByUserId(@Param("user_id") Long userId);

    @Modifying
    @Query("update Game g set g.isWin = true where g.id = :game_id")
    int updateIsWinTrueByGameId(@Param("game_id") Long gameId);

    @Modifying
    @Query(value = "update t_game set is_win = true where id = :game_id",
    nativeQuery = true)
    int updateIsWinTrueByGameIdNative(@Param("game_id") Long gameId);

}
