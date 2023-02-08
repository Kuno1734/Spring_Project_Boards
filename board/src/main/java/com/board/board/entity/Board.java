package com.board.board.entity;

import com.board.board.dto.BoardRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor //기본생성자 자동으로
public class Board extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String username;

    @Column(columnDefinition = "Text",nullable = false)
    private String contents;

    @Column(nullable = false)
    private String password;



    public Board(BoardRequestDto boardRequestDto){
        this.title = boardRequestDto.getTitle();
        this.username = boardRequestDto.getUsername();
        this.contents = boardRequestDto.getContents();
        this.password = boardRequestDto.getPassword();
    }

    public void update(BoardRequestDto boardRequestDto){
        this.title = boardRequestDto.getTitle();
        this.username = boardRequestDto.getUsername();
        this.contents = boardRequestDto.getContents();
        this.password = boardRequestDto.getPassword();
    }
}
