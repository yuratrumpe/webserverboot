package com.yuratrumpe.webserverboot.controller;

import com.yuratrumpe.webserverboot.model.Role;
import com.yuratrumpe.webserverboot.model.User;
import com.yuratrumpe.webserverboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleRestController {

    private final RoleService roleService;

    @Autowired
    public RoleRestController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("")
    public List<Role> getAllRoles() {

        return roleService.getAllRoles();

    }

    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable Long id) {

        return roleService.getRoleById(id);
    }

    @PostMapping("")
    public Role addRole(@RequestBody Role role) {

        return roleService.addRole(role);
    }

    @PutMapping("/{id}")
    public Role updateRole(@PathVariable Long id, @RequestBody Role role) {

        if (roleService.getRoleById(id) == null)
            return null;

        role.setId(id);

        return roleService.updateRole(role);
    }

    @DeleteMapping("/{id}")
    public Role deleteRoleById(@PathVariable Long id) {

        return roleService.deleteRoleById(id);
    }

}
