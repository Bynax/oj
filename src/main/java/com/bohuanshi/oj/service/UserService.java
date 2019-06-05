package com.bohuanshi.oj.service;

import com.bohuanshi.oj.dao.UserDAO;
import com.bohuanshi.oj.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: bohuanshi
 * @Date: 2019/6/5 19:05
 * @Description:
 */

@Service
public class UserService {
    public User getUserByUsername(String userName){
        return userDAO.getUserByUserName(userName);
    }
    @Autowired
    UserDAO userDAO;
}
