package com.board.study.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.board.study.dto.BoardDto;

@Mapper
public interface BoardMapper {

//	@Select("SELECT * FROM board")
    List<BoardDto> selectBoard();
	
//	@Insert("INSERT INTO board(title, content, reg_id) VALUES(#{TITLE}, #{CONTENT}, #{REG_ID})")
//	@Options(useGeneratedKeys = true, keyProperty = "ID")
	void saveBoard(BoardDto boardDto);

//	@Select("SELECT * FROM board WHERE id=#{id}")
	BoardDto findById(int id);

	void updateBoard(BoardDto boardDto);

	void deleteBoard(int id);
}
