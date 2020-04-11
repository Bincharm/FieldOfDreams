package com.boots.repository;

import com.boots.entity.LetterState;
import com.boots.model.ReportWordModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LetterStateRepository extends JpaRepository<LetterState, Long> {

//    @Query(value = "select ls.letter, ls.is_correct, ls.try_time\n" +
//            "from LetterState ls\n" +
//            "where game_id = :game_id\n" +
//            "order by try_time desc",
//            nativeQuery = true)
//    List<ReportWordModel> findAllGameAttemptsByGameId(@Param("game_id") Long gameId);
    List<LetterState> findAllByGame_IdOrderByTryTimeAsc(Long gameId);
}
