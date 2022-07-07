package com.spring.webmvc.member.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter
@ToString

public class Member {

    private static int sequence; // 일련번호
    //  static 스테틱을 붙임으로써 공유되니까(하나만 있어야 되니까) 이걸 꼭 스테틱을 붙여줘야 된다
    private int userNum;
    private String account ;
    private String password;
    private String userName;

    public Member(){
        this.userNum = ++sequence;
    }

    public Member(String account, String password, String userName) {
        this();
        this.account = account;
        this.password = password;
        this.userName = userName;
    }


}
