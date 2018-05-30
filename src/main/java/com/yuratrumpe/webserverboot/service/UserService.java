package com.yuratrumpe.webserverboot.service;

import com.yuratrumpe.webserverboot.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long userId);

    User getUserByName(String userName);

    void addUser(User user);

    void deleteUser(Long userId);

    void updateUser(User user);
}
