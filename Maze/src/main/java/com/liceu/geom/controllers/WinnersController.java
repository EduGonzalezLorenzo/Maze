package com.liceu.geom.controllers;

import com.liceu.geom.model.Game;
import com.liceu.geom.services.GameService;
import com.liceu.geom.services.WinnerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/winners")
public class WinnersController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Se borra la sesión actual (si hay una partida empezada se perderá).
        HttpSession session = req.getSession();
        req.setAttribute("gameJson", null);
        session.setAttribute("game", null);
        //Se obtiene la lista de ganadores de la base de datos y se envia al cliente.
        req.setAttribute("winners", WinnerService.getWinners());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/winners.jsp");
        dispatcher.forward(req, resp);
    }
}