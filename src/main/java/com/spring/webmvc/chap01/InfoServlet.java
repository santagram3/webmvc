package com.spring.webmvc.chap01;

/*
    # 서블릿: http 요청과 응답 데이터를 쉽게 처리할
            수 있도록 도와주는 자바의 API
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/info") // 약속 요청을 보내고싶으면 저걸 해야됨
public class InfoServlet extends HttpServlet {

    public InfoServlet() {
        System.out.println("\n\n\nInfoServlet request! call !!\n\n\n");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("info request.");

        // 요청정보 받기
        double height = Double.parseDouble(req.getParameter("height"));
        double weight = Double.parseDouble(req.getParameter("weight"));
        // 응답 정보 생성하기
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        PrintWriter w = resp.getWriter();

        w.write("<html>");
        w.write("<body>");
        double BMI = calcBMI(height, weight);
        w.write("<h1>당신의 BMI지수는  " + BMI + "군요???</h1>");
        if (BMI > 25.0) {
            System.out.println("<h1>당신은 과체중입니다.</h1>");
        } else if (15 <= BMI || BMI < 25.0) {
            System.out.println("<h1>당신은 중체중입니다.</h1>");
        } else {
            System.out.println("<h1>당신은 저체중입니다.</h1>");
        }
        w.write("</body>");
        w.write("</html>");


    }


    private double calcBMI(double cm, double kg) {
        double m = cm / 100;
        double bmi = kg / (m * m);
        return bmi;

    }
}