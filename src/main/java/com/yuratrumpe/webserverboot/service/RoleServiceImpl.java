package com.yuratrumpe.webserverboot.service;

import com.yuratrumpe.webserverboot.dao.RoleDao;
import com.yuratrumpe.webserverboot.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> getAllRoles() {

        List<Role> roles = new ArrayList<>();

        roleDao.findAll().forEach(roles::add);

        return roles;
    }

    @Override
    public Role getRoleByName(String roleName) {

        return roleDao.findByName(roleName);
    }

    @Override
    public Role getRoleById(Long roleId) {
        return roleDao.findById(roleId).isPresent() ? roleDao.findById(roleId).get() : null;
    }

    @Override
    public Role addRole(Role role) {
        return roleDao.save(role);
    }

    @Override
    public Role updateRole(Role role) {
        return roleDao.save(role);
    }

    @Override
    public Role deleteRoleById(Long roleId) {
        Role role = this.getRoleById(roleId);
        if (role != null) {
            roleDao.deleteById(roleId);
        }
        return role;
    }
}
