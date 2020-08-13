package com.chinasoft.um.service.impl;

import com.chinasoft.um.dao.UserDao;
import com.chinasoft.um.model.PageInfo;
import com.chinasoft.um.model.User;
import com.chinasoft.um.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    private UserDao dao = new UserDao();

    /**
     *  查询所有用户
     * @return
     */
    @Override
    public List<User> findAllUsers() {
        return dao.findAll();
    }

    /**
     * 用户登录
     * @return
     */
    @Override
    public User loginUser(User loginUser) {
        return dao.findUserByNameAndPassWord(loginUser);
    }

    /**
     * 新增用户
     * @param user
     */
    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    @Override
    public User findOne(Integer id) {
        return dao.findUserById(id);
    }

    /**
     * 修改用户
     * @param user
     */
    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    /**
     * 根据id删除用户
     * @param id
     */
    @Override
    public void deleteOne(Integer id) {
        dao.deleteOne(id);
    }

    /**
     * 删除选中
     * @param ids
     */
    @Override
    public void deleteUsers(String[] ids) {
        for (String id : ids) {
            Integer i = Integer.valueOf(id);
            dao.deleteOne(i);
        }
    }

    /**
     * 分页查询
     * @return
     */
    @Override
    public PageInfo<User> findUserByPage(String pageNum, String rows, Map<String, String[]> condition) {
        Integer pageNumber = Integer.valueOf(pageNum);
        Integer rowNum = Integer.valueOf(rows);
//        private Integer totalNum;  //总的记录数
        Integer totalNum =  dao.findTotalPage(condition);
//        private Integer totalPage; //总的页数
        Integer totalPage =  totalNum%rowNum == 0?(totalNum/rowNum):(totalNum/rowNum)+1;
//        List<T> list;               //页面显示记录信息
        Integer start = (pageNumber-1)*rowNum;
        List<User> list = dao.findUserByPage(start,rowNum,condition);
        PageInfo<User> pageInfo = new PageInfo<>(pageNumber,rowNum,totalNum,totalPage,list);
        return pageInfo;
    }
}
