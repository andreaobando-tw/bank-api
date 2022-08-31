package com.tw.bankapi.dao.repository;

import com.tw.bankapi.entities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UsersEntity, Integer>, JpaSpecificationExecutor<UsersEntity> {
    UsersEntity findByNameUserAndPasswordUser(String nameUser, String passwordUser);
}
