package com.boots.model;

import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReportUserModel {

    private String username;
    private Long gameId;
    private String word;
    private Date gameDate;
    private Boolean isWin;

    public ReportUserModel(Long gameId, String word, Date gameDate, Boolean isWin) {
        this.gameId = gameId;
        this.word = word;
        this.gameDate = gameDate;
        this.isWin = isWin;
    }

}
