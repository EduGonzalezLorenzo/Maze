package com.liceu.geom.controllers;

import com.liceu.geom.model.Game;
import com.liceu.geom.services.GameService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/reset")
public class ResetController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Game game = (Game) session.getAttribute("game");
        Game newGame = GameService.createNewGame(game.getMazeMap().getId());

        session.setAttribute("game", newGame);
        resp.sendRedirect("/nav");
    }
}
