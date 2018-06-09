package com.yuratrumpe.webserverboot.security.service;


import com.yuratrumpe.webserverboot.model.User;
import com.yuratrumpe.webserverboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class AuthenticationService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public AuthenticationService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userService.getUserByName(s);

        if (user == null) {
            throw new UsernameNotFoundException("Username " + s + " not found");
        }

        return user;
    }
}
