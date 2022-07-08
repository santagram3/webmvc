package com.spring.webmvc.servlet.chap04.v4.controller;

// 안쓰는 임포트 다 지우기
// 컨트롤 알트 영어 O

import com.spring.webmvc.servlet.chap04.Model;

import java.util.Map;


public interface ControllerV4 {

    /*
        @param paramMap : 요청정보(쿼리 파라미터)를 모두 읽어서 맵에 담아줌.
        @param model : view에게 보낼 데이터 객체
            @return 포워딩 할 파일명 or 리다이렉트할 경로

    */

  String process(Map<String,String> paramMap, Model model);



}