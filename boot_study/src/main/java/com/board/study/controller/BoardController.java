package com.board.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.board.study.dto.BoardDto;
import com.board.study.service.BoardService;

@RestController
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	//list페이지로 이동
	@GetMapping("/")
    public ModelAndView list() {
		ModelAndView mav = new ModelAndView("board/list");
		List<BoardDto> boardList = boardService.getBoardlist();
		
//		model.addAttribute("boardList", boardList);
		mav.addObject("boardList", boardList);
        return mav;
    }
	
	//write 페이지로 이동
	@GetMapping("/post")
	public ModelAndView write() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/write");
        return mav;
    }
	
	//write 실행
	@PostMapping("/post")
    public ModelAndView write(BoardDto boardDto) {
		ModelAndView mav = new ModelAndView();
		
        boardService.savePost(boardDto);
        
        mav.setViewName("redirect:/");
        return mav;
    }
	
	@GetMapping("/post/{no}")
    public ModelAndView detail(@PathVariable("no") int no) {
		ModelAndView mav = new ModelAndView();
		
        BoardDto boardDTO = boardService.getPost(no);

        mav.addObject("boardDto", boardDTO);
        mav.setViewName("board/detail");
        
        return mav;
    }

    @GetMapping("/post/edit/{no}")
    public ModelAndView edit(@PathVariable("no") int no) {
    	ModelAndView mav = new ModelAndView();
    	
        BoardDto boardDTO = boardService.getPost(no);

        mav.addObject("boardDto", boardDTO);
        mav.setViewName("board/update");
        
        return mav;
    }

    @PutMapping("/post/edit/{no}")
    public ModelAndView update(BoardDto boardDTO, @PathVariable("no") int no) {
    	ModelAndView mav = new ModelAndView();
    	
        boardService.updateBoard(boardDTO, no);
        
        mav.setViewName("redirect:/");
        
        return mav;
    }

    @DeleteMapping("/post/{no}")
    public ModelAndView delete(@PathVariable("no") int no) {
    	ModelAndView mav = new ModelAndView();
    	
        boardService.deleteBoard(no);
        
        mav.setViewName("redirect:/");

        return mav;
    }
}
