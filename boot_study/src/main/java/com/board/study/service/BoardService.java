package com.board.study.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.board.study.dto.BoardDto;
import com.board.study.mapper.BoardMapper;


@Service
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
    public void savePost(BoardDto boardDTO) {
        boardMapper.saveBoard(boardDTO);
    }
	
    public List<BoardDto> getBoardlist() {
        return boardMapper.selectBoard();
    }
	
    public BoardDto getPost(int id) {
        return boardMapper.findById(id);
    }

	public void updateBoard(BoardDto boardDTO, int no) {
		boardMapper.updateBoard(boardDTO);
	}

	public void deleteBoard(int id) {
		boardMapper.deleteBoard(id);
	}
}
