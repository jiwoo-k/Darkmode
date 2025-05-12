package com.lec.spring.controller;

import com.lec.spring.domain.Board;
import com.lec.spring.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;
    public BoardController(BoardService boardService) {
        System.out.println("일단 생성");
        this.boardService = boardService;
    }
// 수정, 추가의 경우 attr name을 result 로 하였음
    @GetMapping("/write")
    public void write (){}

    @PostMapping("/write")
    public String write (Board board, Model model) {
        int result = boardService.write(board);
        model.addAttribute("result", result);
        return "board/write";
    }
    @GetMapping("/list")
    public String list (Model model){
        model.addAttribute("board", boardService.list());
        return "board/list";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model){
        model.addAttribute("board", boardService.detail(id));
        return "board/detail";
    }
    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable Long id){
        model.addAttribute("board", boardService.detail(id));
        return "board/update";
    }
    @GetMapping("/update")
    public String update(Model model, Board board){
        int result = boardService.update(board);
        model.addAttribute("result", result);
        return "board/update";
    }
    @GetMapping("/delete")
    public String delete(Long id, Model model){
        model.addAttribute("board", boardService.delete(id));
        return "board/delete";
    }

}
