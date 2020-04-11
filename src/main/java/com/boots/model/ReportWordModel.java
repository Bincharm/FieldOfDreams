package com.boots.model;

import lombok.*;

import java.sql.Timestamp;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReportWordModel {

    private String letter;
    private Boolean isCorrect;
    private Timestamp tryTime;

}
