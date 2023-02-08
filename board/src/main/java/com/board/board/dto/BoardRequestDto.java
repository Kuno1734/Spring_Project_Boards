package com.board.board.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BoardRequestDto {

    private String title;
    private String username;
    private String contents;
    private String password;

}
