package com.board.board.service;

import com.board.board.dto.BoardDeleteMassgeDto;
import com.board.board.dto.BoardRequestDto;
import com.board.board.dto.BoardResponseDto;
import com.board.board.entity.Board;
import com.board.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public List<BoardResponseDto> getBoard() {
        List<Board> boardList = boardRepository.findAllByOrderByModifiedAtDesc();
        List<BoardResponseDto> boardResponseDtoList = new ArrayList<>();
        for(Board i : boardList){
            BoardResponseDto list = new BoardResponseDto(i);
            boardResponseDtoList.add(list);
        }
        return  boardResponseDtoList;
    }
    @Transactional(readOnly = true)
    public BoardResponseDto getBoard(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존제하지 않습니다.")
        );
        return new BoardResponseDto(board);
    }

    @Transactional
    public BoardResponseDto createBoard(BoardRequestDto requestDto){
        Board board = new Board(requestDto);
        boardRepository.save(board);
        return new BoardResponseDto(board);
    }



    @Transactional
    public BoardResponseDto update(Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존제하지 않습니다.")
        );
        if (requestDto.getPassword().equals(board.getPassword())) {
            board.update(requestDto);//RequestDto로 입력받은 내용대로 변경
        }
        return new BoardResponseDto(board);
    }

    @Transactional
    public BoardDeleteMassgeDto delete(Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존제하지 않습니다.")
        );
        if (requestDto.getPassword().equals(board.getPassword())) {
            boardRepository.deleteById(id);//id값으로 찾아서
            return new BoardDeleteMassgeDto("정상적으로 삭제되었습니다.");
        }
        return new BoardDeleteMassgeDto("비밀번호가 일치하지 않습니다.");
    }


}
