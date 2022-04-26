package com.board.study.domain.entity;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "board")
public class BoardEntity extends TimeEntity {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long ID;

    @Column(length = 10, nullable = false)
    private String REG_ID;

    @Column(length = 100, nullable = false)
    private String TITLE;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String CONTENT;

    @Builder
    public BoardEntity(Long ID, String TITLE, String REG_ID, String CONTENT) {
        this.ID = ID;
        this.REG_ID = REG_ID;
        this.TITLE = TITLE;
        this.CONTENT = CONTENT;
    }
}
