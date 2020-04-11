package com.boots.model;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WordCheckResponseModel {

    private String wordFromDB;
    private Boolean isWin;

}
