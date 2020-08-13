package com.chinasoft.um.controller;

import com.chinasoft.um.model.User;
import com.chinasoft.um.service.UserService;
import com.chinasoft.um.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        UserService service = new UserServiceImpl();
        List<User> users = service.findAllUsers();
        req.setAttribute("list",users);
        req.getRequestDispatcher("/list.jsp").forward(req,resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
