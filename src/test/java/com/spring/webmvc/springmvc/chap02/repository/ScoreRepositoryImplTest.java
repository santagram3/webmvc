package com.spring.webmvc.springmvc.chap02.repository;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest // 의존성 주입을 테스트라인에서 사용 가능
class ScoreRepositoryImplTest {

    @Autowired
    ScoreRepository repository;

    @Test
    @DisplayName("성적 정보가 데이터베이스 테이블에 삽입 되어야 한다 ")
    void saveTest() {
        Score s = new Score("하지마", 12, 33, 20);
        boolean result = repository.save(s);
        assertTrue(result);
    }


    @Test
    @DisplayName("성적 정보가 데이터베이스에서 삭제 되어야 한다 ")
    @Transactional
    @Rollback
    void removeTest() {
        int stuNum = 2;
        boolean result = repository.remove(stuNum);

        assertTrue(result);

    }

    @Test
    @DisplayName("모든 성적 정보가 나와야 한다 ")
    void findAllTest(){
        List<Score> all = repository.findAll();
        for (Score score : all) {
            System.out.println(score.toString());
        }
//        all.forEach(s -> System.out.println(s));
    }
    @Test
    @DisplayName("선택한 선택정보가 나와야 한다 ")
    void findOneTest(){
        int stuNum = 4;
        Score one = repository.findOne(stuNum);
        System.out.println("\n================\n");
        System.out.println(one.toString());
        System.out.println("\n================\n");
        assertEquals("하지마",one.getName());
    }
    @Test
    @DisplayName("총 점수 순으로 나오아ㅑ 한ㄷ ㅏ ")
    void arrayTotalTest(){
        List<Score> arrayTotal = repository.arrayTotal();
        for (Score score : arrayTotal) {
            System.out.println(score);
        }
    }

}