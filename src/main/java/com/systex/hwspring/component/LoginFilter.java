package com.systex.hwspring.component;

import com.systex.hwspring.model.user.Users;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {"/game/*","/lottery/*","/","/index"})
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request =(HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession httpSession =request.getSession();
        Users user= (Users)httpSession.getAttribute("user");
        System.out.println("123");
        if(user == null){
            response.sendRedirect(request.getContextPath() + "/user/login");
        }


        filterChain.doFilter(servletRequest,servletResponse);


    }

}
