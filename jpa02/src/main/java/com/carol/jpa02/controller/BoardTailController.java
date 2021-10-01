package com.carol.jpa02.controller;

import com.carol.jpa02.model.BoardTail;
import com.carol.jpa02.repository.BoardTailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/boardtail")
public class BoardTailController {

    @Autowired
    BoardTailRepository boardTailRepository;

    @PostMapping("/form")
    public String form(BoardTail boardtail) {
        System.out.println(boardtail);
        boardTailRepository.save(boardtail);
        return "redirect:/board/view?id="+boardtail.getBoard_id();
    }

}
