package com.carol.felizvida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.carol.felizvida.dao.BoardDao;
import com.carol.felizvida.dto.BoardDto;

@Controller
@RequestMapping(value="board")
public class BoardController {

	@Autowired
	BoardDao dao;
	
	@RequestMapping(value="main")
	public String main(Model model) {
		List<BoardDto> list = dao.selectlist();
		//최신글 5개가 아니면 5개로 강제로 만들기
		if(list.size() !=5) {
			while(list.size() != 5)
				list.add(new BoardDto());
		}
		model.addAttribute("list", list);
		model.addAttribute("title", "Qna");
		return "board/main";
	}
	

	@RequestMapping(value="qna")
	public String qna(Model model) {
		List<BoardDto> list = dao.selectlist();
		//최신글 5개가 아니면 5개로 강제로 만들기
		if(list.size() !=5) {
			while(list.size() != 5)
				list.add(new BoardDto());
		}
		model.addAttribute("list", list);
		model.addAttribute("title", "Qna");
		return "board/qna";
	}


	@RequestMapping(value="gallery")
	public String gallery(Model model) {
		List<BoardDto> list = dao.selectlist();
		//최신글 5개가 아니면 5개로 강제로 만들기
		if(list.size() !=5) {
			while(list.size() != 5)
				list.add(new BoardDto());
		}
		model.addAttribute("list", list);
		model.addAttribute("title", "Qna");
		return "board/gallery";
	}

	
	
}
