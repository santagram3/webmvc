package com.spring.webmvc.servlet.chap03.controller;

import com.spring.webmvc.servlet.member.model.Member;
import com.spring.webmvc.servlet.member.repository.MemberRepository;
import com.spring.webmvc.servlet.member.repository.MemoryMemberRepo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/mvc/show")
public class ShowServlet extends HttpServlet {

    private final MemberRepository repository = MemoryMemberRepo.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Member> members = repository.findAll();
        System.out.println(members);

        // Model : Controller 와 view 사이의 데이터(List)를 운반하는 수단 객체
        // - 여기서는 모델의 역할은 Request객체가 담당
        req.setAttribute("mList",members); // 리퀘스트 객체에 데이터를 저장하는 코드 // 키값과 같이 넣어줘야함
        // 키 값은 내 맘대로 적어두 됨
        // 여기서 키값은 mList 이다


        String viewName = "/WEB-INF/views/members.jsp";
        RequestDispatcher dp = req.getRequestDispatcher(viewName);
        dp.forward(req, resp);

    }
}
