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

@WebServlet("/game")
public class GameController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Game game = (Game) session.getAttribute("game");

        Player player = game.getPlayer();

        if (player.getLocation().isGoal()) {
            game.setVictory(true);
            session.setAttribute("game", game);
            resp.sendRedirect("/winner");
            return;
        }

        String json = GameService.getJsonInfo(game);

        req.setAttribute("json", json);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/game.jsp");
        dispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
