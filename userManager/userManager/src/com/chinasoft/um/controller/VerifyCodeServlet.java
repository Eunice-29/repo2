package com.chinasoft.um.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/vcode")
public class VerifyCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        //定义图形验证码的长、宽、验证码字符数、干扰线宽度
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(150, 42, 4, 4);
        req.getSession().setAttribute("verfiy",captcha);
        captcha.write(resp.getOutputStream());


    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
