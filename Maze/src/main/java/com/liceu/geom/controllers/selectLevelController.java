package com.liceu.geom.controllers;

import com.liceu.geom.model.MazeMap;
import com.liceu.geom.services.MazeMapService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/select")
public class selectLevelController extends HttpServlet {
    MazeMapService mazeMapService = new MazeMapService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/selectLevel.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int mazeMapID = Integer.parseInt(req.getParameter("mazeMap"));
        MazeMap mazeMap = mazeMapService.getMazeMap(mazeMapID);
        req.setAttribute("map",mazeMap);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/game.jsp");
        dispatcher.forward(req, resp);
    }
}
