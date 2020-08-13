package com.chinasoft.um.controller;

import com.chinasoft.um.model.User;
import com.chinasoft.um.service.UserService;
import com.chinasoft.um.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Map<String, String[]> parameterMap = req.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserService service = new UserServiceImpl();
        service.updateUser(user);
        resp.sendRedirect(req.getContextPath()+"/pageList?pageNum=1&rows=5");


    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
