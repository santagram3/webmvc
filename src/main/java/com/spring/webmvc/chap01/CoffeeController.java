package com.spring.webmvc.chap01;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2 // 뭔뜻이당가 ?
public class CoffeeController {

    // 커피 폼 요청
    @RequestMapping("/coffee/form")
//    localhost : 8181 커밋 1
    public String form(){
//        @Log4j2 이걸 클래스 위에 붙이면
//        System.out.println("/coffe/form Get Request");
//        이걸 //
//      이걸로 바꿀수 있다.  log.info("/coffe/form Get Request");
        log.info("/coffee/form Get Request");
        return "chap01/coffee-form";

    }

    // 커피 주문 요청
    @RequestMapping("/coffee/result")
    public String result(String menu ,  int price, Model model){
//        받은게 보내는거와 이름이 같으면 ?
//        @ModelAttribute 이걸쓰면 모델을 따로 안써도 됨
        //  대신 받을때는 기억을 해야지
//        log.info("/coffee/result Post! -[" + menu + "  " + price + " ]" );
        model.addAttribute("menu",menu);
//        model.addAttribute("price",price);
        model.addAttribute("price",price);

        return "chap01/coffee-result";
    }

}
