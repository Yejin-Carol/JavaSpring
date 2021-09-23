package com.carol.jpa02.controller;

import com.carol.jpa02.model.Board;
import com.carol.jpa02.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class GreetingController {

    @Autowired
    BoardRepository boardRepository;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

   /* @GetMapping("/board")
    public String board(Model model) {
//        List<Board> list = Arrays.asList(
//                new Board(1l,"board1","title1111","1111content","20210916"),
//                new Board(2l,"board2","title2222","2222content","20210917"));
//        model.addAttribute("list", list);
        List<Board> list = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("list", list);
        return "board/board";
    }

    @GetMapping("/form")
    public String form(Board board) {

        return "board/form";
    }

//    @PostMapping("/form")
//    public String form(@RequestParam(name = "title") String title,
//                       @RequestParam(name = "content") String content) {
//        System.out.println(title);
//        System.out.println(content);
//        Board board = new Board();
//        board.setTitle(title);
//        board.setContent(content);
//        boardRepository.save(board);
//        return "board/form";
//    }

    @PostMapping("/form")
    public String form(Model model, @Valid Board board, BindingResult bindingResult) {
        model.addAttribute("board", board);
        if (bindingResult.hasErrors()) {
            //System.out.println("여기로~");
            return "board/form";
        }
        long nano = System.currentTimeMillis();
        String curDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(nano);
        board.setDate(curDate); //save하기 전에 날짜 입력
        boardRepository.save(board);
        return "redirect:/board";
    }*/
}
