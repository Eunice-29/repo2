package com.chinasoft.um.controller;

import com.chinasoft.um.service.UserService;
import com.chinasoft.um.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteUser")
public class DeleteOneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        Integer id = Integer.valueOf(req.getParameter("id")) ;

        UserService service = new UserServiceImpl();

        service.deleteOne(id);

        resp.sendRedirect(req.getContextPath()+"/pageList?pageNum=1&rows=5");


    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
