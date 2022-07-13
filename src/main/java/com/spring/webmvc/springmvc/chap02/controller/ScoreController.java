package com.spring.webmvc.springmvc.chap02.controller;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import com.spring.webmvc.springmvc.chap02.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
public class ScoreController {

    private final ScoreRepository repository;

    // 점수 등록 및 조회 화면 열기
    @RequestMapping("/score/list")
    public String List(Model model) {
        log.info("/score/list Get 요청!");
        // jsp에게 점수 정보를 전달해줘야 함
        List<Score> scoreList = repository.findAll();
        model.addAttribute("scores", scoreList);
        return "chap02/score-list";
    }

    // 점수 신규 등록
    @RequestMapping("/score/register")
    public String register(Score score) {
//        Score score 는 기본생성자를 만들고
//        그 안에를 세터로 만들어서 넣어준다
        // 그래서 여기 안까지 오면
//        Score(name=11, kor=12, eng=12, math=33, stuNum=0, total=0, average=0, grade=F)
        // 이렇게 들어오기때문에 들어온 값을 계산해주는
        score.calcTotalAndAvg();
        score.calcGrade();
        // 메서드를 서서 직접 넣어줘야ㅕ 한ㄷ ㅏ
        log.info("/score/register Post !! " + score);

        return repository.save(score) ? "redirect:/score/list" : "redirect:/";
    }

    @RequestMapping("/score/delete")
    public String delete(int stuNum) {
//        log.info("\n===============================\n");
        log.info("/score/delete Post !! " + stuNum);
//        log.info("\n===============================\n");
        boolean remove = repository.remove(stuNum);

        return remove ? "redirect:/score/list" : "redirect:/";
    }

    @RequestMapping("/score/detail")
    public String detail(int stuNum,Model model) {
        log.info("\n===============================\n");
        log.info("/score/detail Post !! " + stuNum);
        log.info("\n===============================\n");
        Score one = repository.findOne(stuNum);
        model.addAttribute("s",one);

        return "chap02/score-detail";

    }

    @RequestMapping("/score/arrayTotal")
    public String arrayTotal(Model model){
        log.info("\n===============================\n");
        log.info("arrayTotal 받았다 !! ");
        log.info("\n===============================\n");
        List<Score> arrayTotal = repository.arrayTotal();
        model.addAttribute("scores",arrayTotal);
        return "chap02/score-list";
    }
//    @RequestMapping("/score/arrayAverage")


}
