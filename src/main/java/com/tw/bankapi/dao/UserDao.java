package com.tw.bankapi.dao;

import com.tw.bankapi.dao.repository.UserRepository;
import com.tw.bankapi.entities.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    final
    UserRepository userRepository;

    public UserDao(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UsersEntity> findAll(){
        return userRepository.findAll();
    }
}
