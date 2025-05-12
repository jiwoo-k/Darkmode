package com.lec.spring.service;

import com.lec.spring.domain.Board;
import org.springframework.ui.Model;

import java.util.List;

public interface BoardService {
    // 게시판 작성하기
    int write (Board board);

    // id 가져와서 글 읽기
    Board detail (Long id);

    // 게시판 목록
    List<Board> list ();

    // 페이징
    List<Board> list (Integer page, Model model);

    // 게시판 수정하기
    int update(Board board);

    // 게시판 삭제
    int delete(Long id);
}
