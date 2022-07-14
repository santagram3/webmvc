package com.spring.webmvc.springmvc.chap02.repository;


import com.spring.webmvc.springmvc.chap02.domain.Score;

import java.util.List;

// 학생의 성적 정보를 저장 , 조회 , 수정 , 삭제하는 저장소 역할

public interface ScoreRepository {

    // 점수 저장
    boolean save(Score score);
    // 얘 타입은 왜 불린인걸까 ? ?
    // 정답은 ?? :  ~~때문이다 ~~

    // 전체 점수 조회
    List<Score> findAll(String sort);

    // 개별 점수 조회
    Score findOne(int stuNum);

    // 점수 정보 삭제
    boolean remove(int stuNum);

    List<Score> arrayTotal();
    List<Score> arrayAverage();



}
