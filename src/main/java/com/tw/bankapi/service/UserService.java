package com.tw.bankapi.service;

import com.tw.bankapi.dao.UserDao;
import com.tw.bankapi.entities.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    final
    UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<UsersEntity> findAll(){
        return userDao.findAll();
    }
}
