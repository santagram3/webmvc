package com.spring.webmvc.servlet.page_move;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet("/blah")
public class BlahServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 접근 방식에는 2가지가 있는데
        // 클라이언트 = 요청 보내는 사람 (브라우저 // 주소창 ) 으로 들어가는 방법이 있다
       // resp.sendRedirect("/WEB-INF/blah.jsp");
        // 서버 내부에서 들어가는 방법이 있고
//        RequestDispatcher dp = req.getRequestDispatcher("/WEB-INF/blah.jsp");
//        dp.forward(req,resp);


        // 접근 불가 // 클라이언트에 갔다 가니까 안열림
//        resp.sendRedirect("/WEB-INF/blah.jsp");

        // 모델에 데이터 담기
        req.setAttribute("msg","안녕하세여");
        req.setAttribute("number",200);
        req.setAttribute("hobbys", Arrays.asList("수영","독서","수면"));
        req.setAttribute("hobbys2", new ArrayList<>());

        RequestDispatcher dp = req.getRequestDispatcher("/WEB-INF/blah.jsp");
        dp.forward(req,resp);
        // 주소 숨김
        // 클라이언트 직접 접근 막기
        // 안에 정보 막기
        //
    }
}
