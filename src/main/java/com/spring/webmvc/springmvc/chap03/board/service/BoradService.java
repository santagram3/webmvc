package com.spring.webmvc.springmvc.chap03.board.service;

import com.spring.webmvc.springmvc.chap03.board.domain.Board;
import com.spring.webmvc.springmvc.chap03.board.repository.BoardRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 스프링 빈 등록
@RequiredArgsConstructor
public class BoradService {

    private final BoardRepositoryImpl repository;

    // 리스트 주는 서비스
    public List<Board> boardListService() {
        List<Board> boardList = repository.findAll();

        return boardList;
    }

    // 저장하는 서비스
    public boolean boardSaveService(Board board) {
        boolean save = repository.save(board);
        return save;
    }

    // 하나만 찾기 서비스
    public Board boardFindOneService(int boardNo) {
        Board one = repository.findOne(boardNo);
        return one;
    }

    // 지우는 서비스
    public boolean boardRemoveService(int boardNo) {
        boolean remove = repository.remove(boardNo);
        return remove;
    }

}
