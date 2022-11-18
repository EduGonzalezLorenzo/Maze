package com.liceu.geom.controllers;

import com.liceu.geom.model.Game;
import com.liceu.geom.model.Player;
import com.liceu.geom.services.GameService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/endform")
public class EndFormController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/endform.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String playerName = req.getParameter("playerName");
        if (playerName.equals("")) {
            req.setAttribute("logError", "Introduce un nombre!");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/endform.jsp");
            dispatcher.forward(req, resp);
        } else {
            HttpSession session = req.getSession();
            Game game = (Game) session.getAttribute("game");
            Player player = game.getPlayer();
            player.setName(playerName);
            GameService.addPlayerToWinners(game);
            game.setVictory(false);
            req.setAttribute("gameJson", null);
            session.setAttribute("game", null);
            resp.sendRedirect("/winners");
        }
    }
}
