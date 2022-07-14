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
    }
}
