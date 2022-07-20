package com.spring.webmvc.springmvc.chap02.repository;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScoreMapperTest {

    @Autowired
    ScoreMapper scoreMapper;

    @Test
    @DisplayName("10 개 넣어서 다 들어가는지 ")
    void saveTest(){

        for (int i = 0; i <10 ; i++) {
            Score score = new Score("삼"+i,25+i,26+i,27+i);


            scoreMapper.save(score);
        }

    }

    @Test
    @DisplayName("10 개 가 다 들어와야 한다 ")
    void findAllTest(){
        List<Score> all = scoreMapper.findAll();
        for (Score score : all) {
            System.out.println(score);
        }
    }

    @Test
    @DisplayName("학생번호가 4를 가진 사람이 있어야 함 ")
    void findOneTest(){
        Score flag = scoreMapper.findOne(4);
//        assertTrue(flag);

    }


}