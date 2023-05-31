package com.example.springboot.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springboot.example.entity.User;

import java.sql.SQLException;


public interface UserService extends IService<User> {

    User getByName(String name);

    Boolean trans(String fromId, String toId, Double money) throws SQLException;

    Boolean add(User user);

    void deleteByIds(String id);

    Boolean update(User user);

    Boolean updateColle(User User, String bookId, Boolean flag);
}
