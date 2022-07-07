package com.spring.webmvc.chap04.v1;

import com.spring.webmvc.chap04.v1.controller.ControllerV1;
import com.spring.webmvc.chap04.v1.controller.FormController;
import com.spring.webmvc.chap04.v1.controller.SaveController;
import com.spring.webmvc.chap04.v1.controller.ShowController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


// FrontController 모든 요청을 다 처리한다
//@WebServlet("/*") // /* 처리로 모든요청을 다 받는다
@WebServlet("/mvc/v1/*")
public class FrontControllerV1 extends HttpServlet {

    /*
        /mvc/v1/join - 회원가입 폼 요청 -> FormController
        /mvc/v1/save - 회원가입 처리 요청 -> SaveController
        /mvc/v1/show - 회원 목록 조회 요청 -> ShowController

    */

    // 해시맵 사용 : 하위 컨트롤러들을 저장 , 키값은 URL
    private final Map<String, ControllerV1> controllerMap
            = new HashMap<>();

    public FrontControllerV1(){
        controllerMap.put("/mvc/v1/join",new FormController());
        controllerMap.put("/mvc/v1/save",new SaveController());
        controllerMap.put("/mvc/v1/show",new ShowController());

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 현재 들어온 요청 URI를 반환
        String uri = req.getRequestURI();

        System.out.println("front-controller 요청이 들어옴 ~~~ "+ uri);

        // 컨트롤러 맵에서 방금 들어온 요청에 따른 적합한 컨트롤러를 꺼내옴
        ControllerV1 controller = controllerMap.get(uri);


        if (controller == null){
            resp.setStatus(404); // 404 : page not found
            return;
        }

        controller.process(req, resp);

    }
}
