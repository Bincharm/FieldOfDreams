package com.boots.model;

import java.sql.Timestamp;
import java.util.Date;

public class ReportUserModel {

    private String username;
    private Long gameId;
    private String word;
    private Date gameDate;
    private Boolean isWin;

    public ReportUserModel(){
    }

    public ReportUserModel(String username, Long gameId, String word, Date gameDate, Boolean isWin) {
        this.username = username;
        this.gameId = gameId;
        this.word = word;
        this.gameDate = gameDate;
        this.isWin = isWin;
    }

    public ReportUserModel(Long gameId, String word, Date gameDate, Boolean isWin) {
        this.gameId = gameId;
        this.word = word;
        this.gameDate = gameDate;
        this.isWin = isWin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Date getGameDate() {
        return gameDate;
    }

    public void setGameDate(Date gameDate) {
        this.gameDate = gameDate;
    }

    public Boolean getIsWin() {
        return isWin;
    }

    public void setIsWin(Boolean isWin) {
        this.isWin = isWin;
    }
}
