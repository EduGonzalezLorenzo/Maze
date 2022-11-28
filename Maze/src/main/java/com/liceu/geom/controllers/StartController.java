package com.liceu.geom.controllers;

import com.liceu.geom.model.Game;
import com.liceu.geom.services.GameService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/start")
public class StartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //Si hay una partida empezada se perderá al acceder a este menú.
        req.setAttribute("gameJson", null);
        session.setAttribute("game", null);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/start.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //Se genera una partida en función del mapa seleccionado por el usuario.
        int mapId = Integer.parseInt(req.getParameter("mazeMap"));
        Game game = GameService.createNewGame(mapId);
        HttpSession session = req.getSession();
        session.setAttribute("game", game);
        resp.sendRedirect("/nav");
    }
}
