package com.liceu.geom.filters;

import com.liceu.geom.model.Game;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/endform"})
public class EndFormFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        Game game = (Game) session.getAttribute("game");
        if (game == null) {
            res.sendRedirect("/start");
            return;
        }
        if (!game.isVictory()) {
            res.sendRedirect("/nav");
            return;
        }
        chain.doFilter(req, res);
    }
}
