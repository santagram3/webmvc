package com.spring.webmvc.springmvc.chap01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller // 스프링 컨테이너에 빈 등록
// 스프링의 HandlerMapping이 찾아서 DispatcherServlet에 연결함 .
public class BasicController {

    //브라우저 (클라이언트) 요청 받기
    // 메서드 만들기
    @RequestMapping("/spring/about") // 요청 URL을 적음
    public String about(){
        System.out.println("about 요청이 들어옴!!!");

        //  /WEB-INF/views/about.jsp/ 로 감
        // 왜냐하면 application.properties 에
//        # view resolver setting
//        spring.mvc.view.prefix=/WEB-INF/views/
//                spring.mvc.view.suffix=.jsp
        //  이거를 적었기 때문에
        return "about"; // jsp파일 포워딩 ,리다이렉트
    }
    @RequestMapping("/spring/hello") // 요청 URL을 적음
    public String about2(){
        System.out.println("hello 요청이 들어옴!!!");

        // /mvc/join 으로 재요청 (redirect)
        return "redirect:/mvc/join"; // jsp파일 포워딩 ,리다이렉트
    }

    // ====================== 요청 파라미터 받기 (Query Parameter)================//
    // == 1. HttpServletRequest 사용하기
    // == ex) /spring/person?name=kim&age=30
    @RequestMapping("/spring/person")
    public String person(HttpServletRequest request){
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        System.out.println("name = " + name);
        System.out.println("age = " + age);

        return "";

    }

    // 2. @RequestParam 사용하기


    // \\ ex) /spring/major?stu=kim&major=business&grade=3
    @RequestMapping("/spring/major")
    public String major(
            // 메소드 이름 옆 () 에는 prameter 가 들어온다 // 매개변수
      //      @RequestParam("stu") String stu 이 말은
            //주소창에 매개변수로 들어온 stu 는 String 타입 stu 이다 라고 변환 한 말이다

            @RequestParam("stu") String stu
            ,@RequestParam("major") String major
            ,@RequestParam("grade") int grade
    ){

        System.out.println("학생명 = " + stu);
        System.out.println("전공 = " + major);
        System.out.println("학년 = " + grade);
        return "";
    }

    // 요청 파라미터 키값과 메서드 매개변수 이름이 같으면
    // @RequestParam 이 생략 가능
    // \\ ex) /spring/major?stu=kim&major=business&grade=3
    @RequestMapping("/spring/major2")
    public String major2(String stu,String major, int grade){
        System.out.println("학생명2 = " + stu);
        System.out.println("전공2 = " + major);
        System.out.println("학년2 = " + grade);
        return "";
    }


     /// 3. ㅋ커맨드 객체 이용하기
    // == ex)/spring/order?oNum=22&goods=구두&amount=34&price=10000
    // 쿼리 파라미터 키값과 커맨드 객체 필드명이 같아야 인식함.
    // oNum ,goods , amount , price / 대소문자 까지
    // 반드시 setter/getter가 있어야 함
    @RequestMapping("/spring/order")
    public String order(Order order){
        System.out.println(order);
        // 번외
        int amount = order.getAmount();
        System.out.println("amount = " + amount);
        return "";
    }












}
