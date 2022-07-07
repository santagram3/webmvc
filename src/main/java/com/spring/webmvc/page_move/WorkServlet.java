package com.spring.webmvc.page_move;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/work")
public class WorkServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(" work 요청이 들어옴 ! ");

        // 1. redirect // 재요청
        // 클라이언트 갔다가 /jsp/result.jsp 로 감
        // 지금 경로를 적었으니까 경로로 이동해준다
//        resp.sendRedirect("/jsp/result.jsp");

        //resp.sendRedirect("http://www.naver.com");
        // 2. forward : 강제이동
        // 클라이언트로 안돌아가고 /jsp/result.jsp 로 바로감
//        RequestDispatcher rd = req.getRequestDispatcher("/info");
//        rd.forward(req,resp);
        RequestDispatcher rd = req.getRequestDispatcher("/jsp/result.jsp");
                rd.forward(req,resp);
    }
}
