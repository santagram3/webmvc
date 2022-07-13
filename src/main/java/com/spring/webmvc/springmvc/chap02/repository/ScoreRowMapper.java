package com.spring.webmvc.springmvc.chap02.repository;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ScoreRowMapper implements RowMapper<Score> {


    @Override
    public Score mapRow(ResultSet rs, int rowNum) throws SQLException {
        Score s = new Score(rs);
        //  이거 일일이 다 넣어야 되는데  귀찮으니까
//        s.setStuNum(rs.getInt("stu_num"));
//        s.setName(rs.getString("stu_name"));
//        etc...
        return s;
    }
}
