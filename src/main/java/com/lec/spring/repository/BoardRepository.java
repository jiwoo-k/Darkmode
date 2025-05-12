package com.lec.spring.repository;


import com.lec.spring.domain.Board;

import java.util.List;

public interface BoardRepository {
    // 작성한 글 저장하기
    int save (Board post);

    // 특정 id 내용 뽑아오기
    Board findById(Long id);

    // 전체 게시판 목록 가져오기
    List<Board> findAll();

    // 게시판 수정한거 업데이트 하기
    int update(Board post);

    // 게시판 삭제하기
    int delete(Long id);

    // 페이징
    List<Board> selectPage(int page , int rows);

    // 전체 글의 개수
    int countAll();
}
