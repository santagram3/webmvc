package com.spring.webmvc.springmvc.chap03.board.controller;

import com.spring.webmvc.springmvc.chap03.board.domain.Board;
import com.spring.webmvc.springmvc.chap03.board.service.BoradService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Log4j2
public class BoardController {

    private final BoradService service;

//      * 게시물 목록요청: /board/list: GET
    @GetMapping("/board/list")
    public String list(Model model){
        log.info("/board/list - 요 청 들 어 옴 ");
        List<Board> boardList = service.boardListService();
        model.addAttribute("boardList",boardList);
        return "chap02/board/board-list";
    }
    // 여기까지 성공

//     * 게시물 상세조회요청: /board/content: GET


    @RequestMapping("/board/content")
    public String detail(@RequestParam("tt") int boardNo, Model model){
        log.info("\n=======================\n");
        log.info("/board/content - 요 청 들 어 옴 - {}", boardNo);
        log.info("\n=======================\n");
        Board board = service.boardFindOneService(boardNo);
        model.addAttribute("one",board);
        return "chap02/board/board-content";

    }
//    * 게시글 쓰기 화면요청: /board/write: GET
    @GetMapping("/board/write")
    public String write(){
        log.info("\n=======================\n");
        log.info("/board/write - 요 청 들 어 옴 - {}");
        log.info("\n=======================\n");

        return "chap02/board/board-write";
    }

//    * 게시글 등록요청: /board/write: POST
    @PostMapping("/board/write")
    public String write(Board board ,Model model){
        log.info("\n=======================\n");
        log.info("/board/write - 요 청 들 어 옴 - {}", board);
        log.info("\n=======================\n");
        boolean b = service.boardSaveService(board);

        return "redirect:/board/list";
        // redirect:/board/list 재요청 / 주소창에  /board/list 친거랑 같다
        // 포워드 : jsp 띄우는 놈 return "redirect:/board/list"; 는 포워딩
    }


//    게시글 삭제요청: /board/delete: GET
    /**


     * 게시글 쓰기 화면요청: /board/write: GET
     * 게시글 등록요청: /board/write: POST
     * 게시글 삭제요청: /board/delete: GET
     * 게시글 수정화면요청: /board/modify: GET
     * 게시글 수정요청: /board/modify: POST
     */

}
