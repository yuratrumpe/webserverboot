package com.yuratrumpe.webserverboot.service;


import com.yuratrumpe.webserverboot.dao.UserDao;
import com.yuratrumpe.webserverboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {


    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {

        List<User> users = new ArrayList<>();

//        for (User user : userDao.findAll()) {
//            users.add(user);
//        }

        userDao.findAll().forEach(users::add);

        return users;
    }

    @Override
    public User getUserById(Long userId) {

        return userDao.findById(userId).get();
    }

    @Override
    public User getUserByName(String userName) {

        return userDao.findByName(userName);

    }

    @Override
    public void addUser(User user) {

        userDao.save(user);
    }

    @Override
    public void deleteUser(Long userId) {

        userDao.deleteById(userId);

    }

    @Override
    public void updateUser(User user) {

        userDao.save(user);

    }
}
