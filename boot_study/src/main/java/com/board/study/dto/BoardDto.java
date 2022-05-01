package com.board.study.dto;

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
	private int ID;
    private String TITLE;
    private String CONTENT;
    private String REG_ID;
    
    /*
    public BoardEntity toEntity() {
    	BoardEntity boardEntity = BoardEntity.builder()
	    	.ID(ID)
	    	.TITLE(TITLE)
	    	.CONTENT(CONTENT)
	    	.REG_ID(REG_ID)
	    	.build();
    	return boardEntity;
    }*/
    
    @Builder
	public BoardDto(int ID, String TITLE, String CONTENT, String REG_ID) {
		this.ID = ID;
		this.TITLE = TITLE;
		this.CONTENT = CONTENT;
		this.REG_ID = REG_ID;
	}
    
    
}
