package com.yuratrumpe.webserverboot.controller;



import com.yuratrumpe.webserverboot.model.User;
import com.yuratrumpe.webserverboot.service.RoleService;
import com.yuratrumpe.webserverboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {

    private final UserService userService;

    private final RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(path = {"/login"})
    public String login(){
        return "login";
    }

    @PostMapping(path = {"/admin/edit-user"})
    public String editUser(@RequestParam Long id, @RequestParam String username, @RequestParam String password, @RequestParam Long role) {

        User user = userService.getUserById(id);
        user.setName(username);
        user.setPassword(password);
        user.setRole(roleService.getRoleById(role));
        userService.updateUser(user);

        return "redirect:/admin/admin";
    }

    @GetMapping(path = {"/admin/delete-user"})
    public String deleteUser(@RequestParam("id") Long id) {

        userService.deleteUser(id);

        return "redirect:/admin/admin";
    }

    @PostMapping(path = {"/admin/add-user"})
    public String addUser(@ModelAttribute User user, @RequestParam Long role) {

        user.setRole(roleService.getRoleById(role));
        userService.addUser(user);

        return "redirect:/admin/admin";
    }

    @GetMapping(path = {"/user/user"})
    public ModelAndView user(ModelMap modelMap) {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = userService.getUserByName(userDetails.getUsername());

        modelMap.addAttribute("user", user);

        return new ModelAndView("user", modelMap);
    }

    @GetMapping(path = {"/admin/admin"})
    public ModelAndView admin(ModelMap modelMap) {

        modelMap.addAttribute("userList", userService.getAllUsers());
        modelMap.addAttribute("roleList", roleService.getAllRoles());
        modelMap.addAttribute("user", new User());

        return new ModelAndView("admin", modelMap);
    }

}

