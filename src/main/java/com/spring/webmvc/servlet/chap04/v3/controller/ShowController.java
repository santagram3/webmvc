package com.spring.webmvc.servlet.chap04.v3.controller;

import com.spring.webmvc.servlet.chap04.ModelAndView;
import com.spring.webmvc.servlet.member.model.Member;
import com.spring.webmvc.servlet.member.repository.MemberRepository;
import com.spring.webmvc.servlet.member.repository.MemoryMemberRepo;

import java.util.List;
import java.util.Map;

public class ShowController implements ControllerV3 {

    private final MemberRepository repository = MemoryMemberRepo.getInstance();

    @Override
    public ModelAndView process(Map<String,String > paramMap) {

        List<Member> members = repository.findAll();
        ModelAndView mv = new ModelAndView("members");
//        request.setAttribute("mList",members); // 리퀘스트 객체에 데이터를 저장하는 코드 // 키값과 같이 넣어줘야함
        mv.addAttribute("mList",members);

        return mv;


    }
}
