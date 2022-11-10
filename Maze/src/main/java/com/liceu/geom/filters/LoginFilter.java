package com.liceu.geom.filters;

import com.liceu.geom.model.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {""})
public class LoginFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
//        HttpSession session = req.getSession();
//        User currentUser = (User) session.getAttribute("currentUser");
//        if (currentUser == null) {
//            res.sendRedirect("/login");
//            return;
//        }
//
//        req.setAttribute("currentUser", currentUser);
//        chain.doFilter(req,res);

    }
}
