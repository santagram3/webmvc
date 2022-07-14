package com.spring.webmvc.springmvc.chap03;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
public class RequestController {


    @RequestMapping(value = "/req/hello", method = RequestMethod.GET)// 겟 방식에서만 가능
    @ResponseBody
    public String hello(){
        log.info("/req/hello 요청 ! !!");
        return  "hello!!!";
    }

//    @RequestMapping(value = "/req/bye", method = RequestMethod.GET)// 겟 방식에서만 가능
    @GetMapping("/req/bye")
    @ResponseBody
    public String bye(){
        log.info("/req/hello 요청 ! !!");
        return  "bye!!!";
    }

    // URL에서 파라미터 얻기
    // 링크요청은 무조건 get // a 태그
    @GetMapping("/Member/{un}")
    @ResponseBody
    public String member(@PathVariable("un") String userName){
    log.info("1231231231231");
        return "I am" + userName;
    }



}
