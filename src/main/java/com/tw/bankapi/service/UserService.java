package com.tw.bankapi.service;

import com.tw.bankapi.dao.UserDao;
import com.tw.bankapi.entities.UsersEntity;
import com.tw.bankapi.util.BankApiResponse;
import com.tw.bankapi.util.exceptions.BankApiException;
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

    public UsersEntity findByUserNameAndPassword(String userName, String password){
        if(userName == null || userName.isEmpty())
        {
            throw new BankApiException(BankApiResponse.INCOMPLETE_PARAMETERS);
        }

        UsersEntity user = userDao.findByUserNameAndPassword(userName, password);

        if (user == null){
            throw new BankApiException(BankApiResponse.USER_NO_FOUND_LOGIN);
        }
        return user;
    }
}
