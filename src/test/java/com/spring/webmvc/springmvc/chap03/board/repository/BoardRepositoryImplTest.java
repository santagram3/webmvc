package com.spring.webmvc.springmvc.chap03.board.repository;

import com.spring.webmvc.springmvc.chap03.board.domain.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardRepositoryImplTest {
    @Autowired
    BoardRepositoryImpl boardRepository;

    @Test
    @DisplayName("하나만 집어 넣었기 때문에 하나라도 나와야 한다")// 성공
    void findAllTest(){ // 성공
        List<Board> all = boardRepository.findAll();
        for (Board board : all) {
            System.out.println("\n===============\n");
            System.out.println(board);
            System.out.println("\n===============\n");
            assertTrue(all.size() == 1);
        }
    }
    @Test
    @DisplayName("저장 되었는지 true") // 성공
    void saveTest(){
        Board board = new Board("한국", "사람", "입니다." );
        boolean save = boardRepository.save(board);
        assertTrue(save);
    }
    @Test
    @DisplayName("한명의 작성자가 '한국'인지 확인해본다 ") // 성공
    void findOneTest(){
        Board one = boardRepository.findOne(2);
        assertEquals("한국",one.getWriter());
    }
    @Test
    @DisplayName("리무브가 잘 작동 되는지 확인 /그래서 길이가 1 줄었는지 확인한다 ") // 성공
    void removeTest(){
        boolean remove = boardRepository.remove(1);
        assertTrue(remove);

        List<Board> list = boardRepository.findAll();
        assertTrue(list.size() == 0);
    }

}