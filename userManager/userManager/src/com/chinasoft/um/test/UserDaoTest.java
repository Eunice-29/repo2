package com.chinasoft.um.test;

import com.chinasoft.um.dao.UserDao;
import com.chinasoft.um.model.User;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {


    private UserDao dao = new UserDao();


    @Test
    public void findAllTest(){
        List<User> all = dao.findAll();
        System.out.println(all);
    }






}
