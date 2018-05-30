package com.yuratrumpe.webserverboot.security.handler;

import com.yuratrumpe.webserverboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;


@Service
public class AuthSuccessHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    private RoleService roleService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        Collection<? extends GrantedAuthority> authorities =  authentication.getAuthorities();

        if (authorities.contains(roleService.getRoleByName("admin"))) {
            redirectStrategy.sendRedirect(request, response, "/admin/admin");
            return;
        }

        if (authorities.contains(roleService.getRoleByName("user"))) {
            redirectStrategy.sendRedirect(request, response, "/user/user");
        }

    }
}
