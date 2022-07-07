package com.spring.webmvc.chap04.v3.controller;

// 안쓰는 임포트 다 지우기
// 컨트롤 알트 영어 O
import com.spring.webmvc.chap04.View;

import java.util.Map;


public interface ControllerV3 {

    /*
        @param paramMap : 요청정보(쿼리 파라미터)를 모두 읽어서 맵에 담아줌.


    */

    View process(Map<String,String> paramMap);
}