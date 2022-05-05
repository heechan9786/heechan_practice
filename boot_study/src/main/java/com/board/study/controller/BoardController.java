package com.board.study.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ModelAndView write(BoardDto boardDTO) {
		ModelAndView mav = new ModelAndView();

        boardService.savePost(boardDTO);
        
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

    @GetMapping("/go_edit/{id}")
    public ModelAndView edit(@PathVariable("id") int id) {
    	ModelAndView mav = new ModelAndView();
    	
        BoardDto boardDTO = boardService.getPost(id);

        boardDTO.setCONTENT(boardDTO.getCONTENT().replace("\r\n","<br>"));
        
        mav.addObject("boardDto", boardDTO);
        mav.setViewName("board/update");
        
        return mav;
    }

    @PutMapping("/editBoard")
    public Map<Object, Object> update(BoardDto boardDTO) {
    	Map<Object, Object> resultMap = new HashMap<Object, Object>();
    	
        boardService.updateBoard(boardDTO);
        
        resultMap.put("RESULT", "SUCCESS");
        
        return resultMap;
    }

    @DeleteMapping("/deleteBoard")
    public Map<Object, Object> delete(@RequestParam(value="checkArr[]") List<Integer> checkArr) {
    	Map<Object, Object> resultMap = new HashMap<Object, Object>();
    	
    	for(int id : checkArr) {
    		System.out.println(id+"번 게시글 삭제");
    		boardService.deleteBoard(id);
    	}
    	
        resultMap.put("RESULT", "SUCCESS");
        
        return resultMap;
    }
}
