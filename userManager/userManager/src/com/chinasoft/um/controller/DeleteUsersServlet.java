package com.chinasoft.um.controller;

import com.chinasoft.um.service.UserService;
import com.chinasoft.um.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteUsers")
public class DeleteUsersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String[] ids = req.getParameterValues("uid");

        UserService service = new UserServiceImpl();

        service.deleteUsers(ids);

//       删除完毕重新调转列表页面
        resp.sendRedirect(req.getContextPath()+"/pageList?pageNum=1&rows=5");

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
