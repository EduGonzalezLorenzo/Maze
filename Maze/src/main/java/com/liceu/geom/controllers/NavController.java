package com.liceu.geom.controllers;

import com.liceu.geom.model.Game;
import com.liceu.geom.model.Side;
import com.liceu.geom.services.GameService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/nav")
public class NavController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Game game = (Game) session.getAttribute("game");
        String msg;
        String dir = req.getParameter("dir");

        if (dir != null) msg = GameService.movePlayer(game, dir);
        else msg = GameService.chargeCurrentLocation(game);

        String json = GameService.getJsonInfo(game);

        req.setAttribute("gameJson", json);
        req.setAttribute("msg", msg);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/navigation.jsp");
        dispatcher.forward(req, resp);
    }

}
