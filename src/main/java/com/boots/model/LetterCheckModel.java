package com.boots.model;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LetterCheckModel {
    private Long wordId;
    private String letter;
    private Long gameId;

}
