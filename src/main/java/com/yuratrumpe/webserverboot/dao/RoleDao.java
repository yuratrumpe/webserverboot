package com.yuratrumpe.webserverboot.dao;


import com.yuratrumpe.webserverboot.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao extends CrudRepository<Role, Long> {

    Role findByName(String name);

}
