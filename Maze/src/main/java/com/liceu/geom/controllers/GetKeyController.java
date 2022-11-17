package com.liceu.geom.controllers;

import com.liceu.geom.model.*;
import com.liceu.geom.services.RoomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/getkey")
public class GetKeyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Game game = (Game) session.getAttribute("game");
        Room room = game.getPlayer().getLocation();
        Player player = game.getPlayer();
        String status;
        if (RoomService.hasKey(room)) {
            status = RoomService.giveKeyToPlayer(room, player);
        } else {
            resp.sendRedirect("/nav");
            return;
        }
        game.setPlayer(player);
        session.setAttribute("game", game);
        session.setAttribute("status", status);
        resp.sendRedirect("/nav");
    }
}
