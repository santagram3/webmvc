package com.spring.webmvc.servlet.chap04.v4.controller;

import com.spring.webmvc.servlet.chap04.Model;
import com.spring.webmvc.servlet.member.model.Member;
import com.spring.webmvc.servlet.member.repository.MemberRepository;
import com.spring.webmvc.servlet.member.repository.MemoryMemberRepo;

import java.util.Map;

public class RemoveOneController implements ControllerV4{

    private MemberRepository repository
            = MemoryMemberRepo.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Model model) {
        //삭제처리
        Member member = repository.remove(Integer.parseInt(paramMap.get("userNum")));
//
//        model.addAttribute("m", member);
        // 이건 왜 안하는지 모르겠다
        return "redirect:/mvc/v4/show";
    }
}
