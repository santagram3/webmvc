package com.spring.webmvc.springmvc.chap03.board.repository;


import com.spring.webmvc.springmvc.chap03.board.domain.Board;

import java.util.List;

public interface BoardRepository {

    // 저장하기
    boolean save(Board board);
    // 얘 타입은 왜 불린인걸까 ? ?
    // 정답은 ?? :  ~~때문이다 ~~

    // 전체 점수 조회
    List<Board> findAll();

    // 개별 점수 조회
    Board findOne(int boardNo);

    // 점수 정보 삭제
    boolean remove(int boardNo);

    /**
     * 게시물 목록요청: /board/list: GET
     * 게시물 상세조회요청: /board/content: GET
     * 게시글 쓰기 화면요청: /board/write: GET
     * 게시글 등록요청: /board/write: POST
     * 게시글 삭제요청: /board/delete: GET
     * 게시글 수정화면요청: /board/modify: GET
     * 게시글 수정요청: /board/modify: POST
     */
    // 목록 요청
    // 상세조회
    // 게시글 쓰기
    // 게시글 등록
    //게시글 삭제



}
