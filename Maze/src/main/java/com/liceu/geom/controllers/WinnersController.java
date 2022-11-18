package com.liceu.geom.controllers;

import com.liceu.geom.DAO.WinnersDaoImpl;
import com.liceu.geom.model.Game;
import com.liceu.geom.services.GameService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/winners")
public class WinnersController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("winners", GameService.getWinnersJson());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/winners.jsp");
        dispatcher.forward(req, resp);
    }
}