package com.board.board.controller;

import com.board.board.dto.BoardDeleteMassgeDto;
import com.board.board.dto.BoardRequestDto;
import com.board.board.dto.BoardResponseDto;

import com.board.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardController {

    private final BoardService boardService;



    @GetMapping("/boards")
    public List<BoardResponseDto> getBoard() { return boardService.getBoard();}

    @GetMapping("/boards/{id}")
    public BoardResponseDto getBoard(@PathVariable Long id){
        return boardService.getBoard(id);
    }

    @PostMapping("/boards")
    public BoardResponseDto createBoard(@RequestBody BoardRequestDto requestDto) {
        return boardService.createBoard(requestDto); }

    @PutMapping("/boards/{id}")
    public BoardResponseDto updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto){
        return boardService.update(id,requestDto);
    }

    @DeleteMapping("/boards/{id}")
    public BoardDeleteMassgeDto delete(@PathVariable Long id, @RequestBody BoardRequestDto requestDto){
        return boardService.delete(id, requestDto);
    }


}
