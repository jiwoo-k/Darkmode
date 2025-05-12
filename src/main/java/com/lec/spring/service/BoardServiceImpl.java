package com.lec.spring.service;

import com.lec.spring.domain.Board;
import com.lec.spring.repository.BoardRepository;
import com.lec.spring.repository.UserRepository;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
@Service
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    public BoardServiceImpl(SqlSession sqlSession) {
        this.boardRepository = sqlSession.getMapper(BoardRepository.class);
        this.userRepository = sqlSession.getMapper(UserRepository.class);
    }
    @Override
    public int write(Board board) {
        return boardRepository.save(board);
    }

    @Override
    public Board detail(Long id) {
        return boardRepository.findById(id);
    }

    @Override
    public List<Board> list() {
        return boardRepository.findAll();
    }

    @Override
    public List<Board> list(Integer page, Model model) {
        return List.of();
    }

    @Override
    public int update(Board board) {
        return boardRepository.update(board);
    }

    @Override
    public int delete(Long id) {
        int result = 0;
        boardRepository.findById(id);
        Board board = boardRepository.findById(id);
        if (board != null) {
            result = boardRepository.delete(id);
        }
        return result;
    }
}
