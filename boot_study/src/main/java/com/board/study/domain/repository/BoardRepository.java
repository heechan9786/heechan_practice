package com.board.study.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.board.study.domain.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

}
