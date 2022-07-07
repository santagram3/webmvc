package com.spring.webmvc.chap04.v3.controller;

import com.spring.webmvc.chap04.View;
import com.spring.webmvc.chap04.v2.controller.ControllerV2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class FormController implements ControllerV3 {


    @Override
    public View process(Map<String,String>paramMap) {

        return new View("/WEB-INF/views/reg_form.jsp");


    }
}
