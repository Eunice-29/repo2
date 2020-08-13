package com.chinasoft.um.controller;

import cn.hutool.captcha.ShearCaptcha;
import com.chinasoft.um.model.User;
import com.chinasoft.um.service.UserService;
import com.chinasoft.um.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String verifycode = req.getParameter("verifycode");
        Map<String, String[]> parameterMap = req.getParameterMap();
        User loginUser = new User();
        try {
//        将获取的参数map集合封装到对象中
        BeanUtils.populate(loginUser,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserService userService = new UserServiceImpl();
        HttpSession session = req.getSession();
        ShearCaptcha captcha = (ShearCaptcha)session.getAttribute("verfiy");
        if (!captcha.verify(verifycode)){
            session.removeAttribute("verfiy");
            req.getServletContext().setAttribute("msg","验证码错误!!");
            resp.sendRedirect(req.getContextPath()+"/login.jsp");
        }else {
            User user = userService.loginUser(loginUser);
            if (user != null){
                resp.sendRedirect(req.getContextPath()+"/index.jsp");
            }else {
                session.removeAttribute("verfiy");
                req.getServletContext().setAttribute("msg","用户名或密码错误！");
                resp.sendRedirect(req.getContextPath()+"/login.jsp");
            }
        }








    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
