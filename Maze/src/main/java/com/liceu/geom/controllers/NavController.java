package com.liceu.geom.controllers;

import com.liceu.geom.model.Game;
import com.liceu.geom.model.Player;
import com.liceu.geom.model.Room;
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
        Player player = game.getPlayer();
        Room room = player.getLocation();
        String status = null;
        if (room.isGoal()) {
            status = "HAS GANADO!!!";
            game.setVictory(true);
        } else {
            if (session.getAttribute("status") != null) status = session.getAttribute("status").toString();
            String dir = req.getParameter("dir");
            if (dir != null) status = GameService.movePlayer(game, dir);
        }
        String json = GameService.getJsonInfo(game, status);

        req.setAttribute("gameJson", json);
        session.setAttribute("status", null);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/navigation.jsp");
        dispatcher.forward(req, resp);
    }

}
