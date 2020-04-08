package com.boots.model;

public class WordCheckResponseModel {

    private String wordFromDB;
    private Boolean isWin;

    public WordCheckResponseModel(){
    }

    public String getWordFromDB() {
        return wordFromDB;
    }

    public void setWordFromDB(String wordFromDB) {
        this.wordFromDB = wordFromDB;
    }

    public Boolean getIsWin() {
        return isWin;
    }

    public void setIsWin(Boolean win) {
        isWin = win;
    }
}
