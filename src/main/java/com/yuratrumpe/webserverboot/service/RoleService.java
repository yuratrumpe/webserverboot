package com.yuratrumpe.webserverboot.service;

import com.yuratrumpe.webserverboot.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();

    Role getRoleByName(String roleName);

    Role getRoleById(Long roleId);

    Role addRole(Role role);

    Role updateRole(Role role);

    Role deleteRoleById(Long roleId);
}
