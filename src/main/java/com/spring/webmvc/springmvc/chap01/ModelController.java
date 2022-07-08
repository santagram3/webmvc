package com.spring.webmvc.springmvc.chap01;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Controller
// 요청처리 하는 컨트롤러
@RequestMapping("/model")
// 이렇게 쓰면 밑에 메서드에 있는
//@RequestMapping("/model/hobbies") 앞에 모델을 띄어낼수있다.
public class ModelController {

    private static class ModelURL {
        public static final String HOBBIES = "/hobbies";
        public static final String HOBBIES2 = "/hobbies2";
        public static final String FORM = "/form";
        public static final String CHECK = "/age-check";
    }


    // ============jsp 파일로 포워딩 할때 데이터 전달하기
    // == 1. Model 객체 사용하기
    @RequestMapping(ModelURL.HOBBIES)
    // @RequestMapping(ModelURL.HOBBIES) 뜻
    //검색창에 http://localhost:8181/model/hobbies
    // 라고 검색하면 밑에 메소드가 실행된다
    public String hobbies(Model model) {

        List<String> hList = new ArrayList<>();
        hList.add("산책");
        hList.add("걷기");
        hList.add("먹기");
        hList.add("하기");
        hList.add("싸기");

        model.addAttribute("name", "멍멍이");
        // name 키값
        model.addAttribute("hobbies", hList);

        // /WEB-INF/views/chap01/hobbies.jsp
        return "chap01/hobbies";
    }

    // =============ModelAndView 사용하기==============//
    @RequestMapping(ModelURL.HOBBIES2)
    public ModelAndView hobbies2() {

        List<String> hList = new ArrayList<>();
        hList.add("영화");
        hList.add("맛집");
        hList.add("떡볶이");
        hList.add("헬스");
        hList.add("크로스핏");

        ModelAndView mv = new ModelAndView("chap01/hobbies");
        mv.addObject("name", "반짝이");
        mv.addObject("hobbies", hList);

        return mv;
    }

    // age-form 띄우기
    @RequestMapping(ModelURL.FORM)
    public String form() {
        return "chap01/age-form";
    }
//
//    // age 데이터 처리
//    @RequestMapping("/model/age-check")
////    @RequestParam("age") 이거 인트 옆에 붙여줘야 되는데 생략가능
//    public String check(int age ,Model model) {
//
//        // 나이로 출생년도 구해주기 (한국나이)
//        int birthYear = LocalDate.now().getYear() - age +1;
//        model.addAttribute("bYear",birthYear);
//        model.addAttribute("age",age);
//
//        return "chap01/age-result";
//    }

    // 3 ======== @ModelAttribute 사용 ====================

//    @ModelAttribute 를 쓰면
    // age 데이터 처리
    @RequestMapping(ModelURL.CHECK)
    public String check2(@ModelAttribute("age") int age , Model model) {

        // 나이로 출생년도 구해주기 (한국나이)
        int birthYear = LocalDate.now().getYear() - age +1;
        model.addAttribute("bYear",birthYear);
        //    @ModelAttribute 를 쓰면
//        밑에 model.addAttribute("age",age);  이 문장을 생략 가능
//        model.addAttribute("age",age);


        return "chap01/age-result";
    }

}
