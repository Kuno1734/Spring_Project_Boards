package com.board.board.dto;

import lombok.Getter;

@Getter
public class BoardDeleteMassgeDto {
    private String message;

    public BoardDeleteMassgeDto(String message) {
        this.message = message;
    }
}
