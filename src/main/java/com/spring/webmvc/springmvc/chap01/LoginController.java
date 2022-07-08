package com.spring.webmvc.springmvc.chap01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hw")
public class LoginController {

    private static class LoginURL {
        public static final String FORM = "/s-login-form";
        public static final String CHECK = "/s-login-check";
    }

     /*
        1번요청: 로그인 폼 화면 열어주기
        - 요청 URL : /hw/s-login-form
        - 포워딩 jsp파일 경로:  /WEB-INF/views/chap01/s-form.jsp
*/

//   /hw/s-login-form
    @RequestMapping(LoginURL.FORM)
    public String form() {
        System.out.println("로그인 화면에 들어오셨습니다.");
        //로그인 화면 열어주기
        return "chap01/s-form";
    }

    /*

        2번요청: 로그인 검증하기
        - 로그인 검증: 아이디를 grape111이라고 쓰고 비번을 ggg9999 라고 쓰면 성공
        - 요청 URL : /hw/s-login-check
        - 포워딩 jsp파일 경로:  /WEB-INF/views/chap01/s-result.jsp
        - jsp에게 전달할 데이터: 로그인 성공여부, 아이디 없는경우, 비번 틀린경우

     */

    @RequestMapping(LoginURL.CHECK)
    public String check(String id, String password, Model model) {
        if (id.equals("grape111")){
            if (password.equals("ggg9999")){

            }
        }else {

        }
        model.addAttribute("id",id);
        model.addAttribute("password",password);
        return "chap01/s-result";
    }

}