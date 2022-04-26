package com.board.study.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.board.study.domain.entity.BoardEntity;
import com.board.study.domain.repository.BoardRepository;
import com.board.study.dto.BoardDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BoardService {
	
	private BoardRepository boardRepository;
	
	@Transactional
    public Long savePost(BoardDto boardDto) {
        return boardRepository.save(boardDto.toEntity()).getID();
    }
	
	@Transactional
    public List<BoardDto> getBoardlist() {
        List<BoardEntity> boardEntities = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for ( BoardEntity boardEntity : boardEntities) {
            BoardDto boardDTO = BoardDto.builder()
                    .ID(boardEntity.getID())
                    .TITLE(boardEntity.getTITLE())
                    .CONTENT(boardEntity.getCONTENT())
                    .REG_ID(boardEntity.getREG_ID())
                    .REG_DATE(boardEntity.getREG_DATE())
                    .build();

            boardDtoList.add(boardDTO);
        }

        return boardDtoList;
    }
	
	@Transactional
    public BoardDto getPost(Long id) {
        Optional<BoardEntity> boardEntityWrapper = boardRepository.findById(id);
        BoardEntity boardEntity = boardEntityWrapper.get();

        BoardDto boardDTO = BoardDto.builder()
                .ID(boardEntity.getID())
                .TITLE(boardEntity.getTITLE())
                .CONTENT(boardEntity.getCONTENT())
                .REG_ID(boardEntity.getREG_ID())
                .REG_DATE(boardEntity.getREG_DATE())
                .build();

        return boardDTO;
    }

    @Transactional
    public void deletePost(Long id) {
        boardRepository.deleteById(id);
    }
}
