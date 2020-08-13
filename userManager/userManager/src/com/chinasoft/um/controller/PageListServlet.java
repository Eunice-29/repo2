package com.chinasoft.um.controller;

import com.chinasoft.um.model.PageInfo;
import com.chinasoft.um.model.User;
import com.chinasoft.um.service.UserService;
import com.chinasoft.um.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/pageList")
public class PageListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String pageNum = req.getParameter("pageNum");
        String rows = req.getParameter("rows");
        Map<String, String[]> condition = req.getParameterMap();
        UserService service = new UserServiceImpl();
//        查询分页信息
        PageInfo<User> info = service.findUserByPage( pageNum, rows,condition);
        req.setAttribute("pageInfo",info);
        req.setAttribute("condition",condition);
        req.getRequestDispatcher("/list.jsp").forward(req,resp);


    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
