package com.spring.webmvc.springmvc.chap03.board.repository;

import com.spring.webmvc.springmvc.chap03.board.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepository {

    private final JdbcTemplate template;

    @Override
    public boolean save(Board board) {
        String sql = "INSERT INTO board (board_no,  writer, title, content )" + " VALUES (seq_board.nextval,?,?,?)";
        return template.update(sql , board.getWriter(),board.getTitle(), board.getContent()) == 1;

    }

    @Override
    public List<Board> findAll() {
        String sql = "select * from board";

        return template.query(sql.toString() ,new BoardRowMapper());
    }

    @Override
    public Board findOne(int boardNo) {
        String sql = "select * from board where board_no=? ";
        return template.queryForObject(sql, new BoardRowMapper(), boardNo);
    }

    @Override
    public boolean remove(int boardNo) {
        String sql = "DELETE FROM board where board_no=?";
        return template.update(sql, boardNo) == 1;
    }
}
