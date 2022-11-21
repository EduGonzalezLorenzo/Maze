package com.liceu.geom.controllers;

import com.liceu.geom.model.Game;
import com.liceu.geom.services.DoorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/open")
public class OpenDoorController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Game game = (Game) session.getAttribute("game");
        String status;
        String dir = req.getParameter("dir");
        if (dir != null) {
            status = DoorService.openDoor(game, dir);
            session.setAttribute("game", game);
            session.setAttribute("status", status);
        }
        resp.sendRedirect("/nav");
    }
}
