package com.yuratrumpe.webserverboot.dao;


import com.yuratrumpe.webserverboot.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, Long>{

    User findByName(String name);

}
