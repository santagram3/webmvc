package com.spring.webmvc.springmvc.chap03.board.repository;

import com.spring.webmvc.springmvc.chap03.board.domain.Board;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class BoardRowMapper implements RowMapper<Board> {


    @Override
    public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
        Board board = new Board(rs);
        return board;
        // ResultSet rs 는 쿼리를 돌려서 나온 값
    }
    //RowMapper<Board> 은

//    while (rs.next()) {
//        Score s = new Score(
//                rs.getInt("stu_num")
//                , rs.getString("stu_name")
//                , rs.getInt("kor")
//                , rs.getInt("eng")
//                , rs.getInt("math")
//                , rs.getInt("total")ㅛ
//                , rs.getDouble("average")
//        );
//        scoreMap.put(s.getStuNum(), s);



    }
