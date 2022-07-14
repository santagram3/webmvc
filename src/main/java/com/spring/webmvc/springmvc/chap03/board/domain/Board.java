package com.spring.webmvc.springmvc.chap03.board.domain;

import lombok.*;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@Getter @Setter

@ToString
@NoArgsConstructor
public class Board {

    private int boardNo; //글 번호
    private String writer; //작성자 이름
    private String title; // 제목
    private String content; // 내용
    private int view_cnt ; // 조회수
    private Date reg_date; // 작성시간

    public Board(String writer ,String title ,String content){
//        this.board_no =board_no;
        this.writer = writer;
        this.title = title;
        this.content = content ;
        this.view_cnt = 0 ;
//        this.reg_date = reg_date;
    }

    public Board(ResultSet rs) throws SQLException{
        this.boardNo = rs.getInt("board_no");
        this.writer = rs.getString("writer");
        this.title = rs.getString("title");
        this.content = rs.getString("content");
        this.view_cnt = rs.getInt("view_cnt");
        this.reg_date = rs.getDate("reg_date");

    }


}
