package com.spring.webmvc.servlet.member.repository;


import com.spring.webmvc.servlet.member.model.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Repository
public class MemoryMemberRepo implements MemberRepository {


    // 회원 정보를 저장할 메모리 저장소
    private Map<Integer , Member> memberMap = new HashMap<>();
    // 싱글톤 패턴 구현
    // 1. 생성자를 단 하나 선언하고 외부에서 객체 만들 수 없게 private로 제한
    private MemoryMemberRepo(){}

    // 2. 스스로의 객체를 단 하나 생성한다 .
    private static MemoryMemberRepo instance = new MemoryMemberRepo();

    // 3. 단 하나의 객체를 리턴하는 메서드를 만든다.
    public  static  MemoryMemberRepo getInstance(){
        return instance;
    }



    @Override
    public void save(Member member) {
        memberMap.put(member.getUserNum(),member);
        System.out.println(memberMap);
    }

    @Override
    public List<Member> findAll() {
        List<Member> memberList = new ArrayList<>();
        for (Integer key : memberMap.keySet()) {
            memberList.add(memberMap.get(key));
        }
        return memberList;

    }

    @Override
    public Member findOne(int userNum) {
        return memberMap.get(userNum);
    }

    @Override
    public Member remove(int userNum) {
        return memberMap.remove(userNum);
    }
}
