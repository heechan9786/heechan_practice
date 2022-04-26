package com.board.study.dto;

import java.time.LocalDateTime;

import com.board.study.domain.entity.BoardEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
	private Long ID;
    private String TITLE;
    private String CONTENT;
    private String REG_ID;
    private LocalDateTime REG_DATE;
    private LocalDateTime MOD_DATE;
    
    public BoardEntity toEntity() {
    	BoardEntity boardEntity = BoardEntity.builder()
	    	.ID(ID)
	    	.TITLE(TITLE)
	    	.CONTENT(CONTENT)
	    	.REG_ID(REG_ID)
	    	.build();
    	return boardEntity;
    }
    
    @Builder
	public BoardDto(Long ID, String TITLE, String CONTENT, String REG_ID, LocalDateTime REG_DATE,
			LocalDateTime MOD_DATE) {
		this.ID = ID;
		this.TITLE = TITLE;
		this.CONTENT = CONTENT;
		this.REG_ID = REG_ID;
		this.REG_DATE = REG_DATE;
		this.MOD_DATE = MOD_DATE;
	}
    
    
}
