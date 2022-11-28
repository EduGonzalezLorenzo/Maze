package com.liceu.geom.controllers;

import com.liceu.geom.model.Game;
import com.liceu.geom.model.Player;
import com.liceu.geom.services.GameService;
import com.liceu.geom.services.NoValidDirException;
import com.liceu.geom.services.PlayerService;

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
        String status = null;

        if (session.getAttribute("status") != null) status = session.getAttribute("status").toString();
        String dir = req.getParameter("dir");
        try {
            // Se comprueba si hay dirección. Si la hay se intenta mover en esa dirección.
            // Si la dirección no es valida se envia error al cliente.
            if (dir != null) status = PlayerService.movePlayer(game, dir);
        } catch (NoValidDirException e){
            error(req, resp);
            return;
        }
        if (player.getLocation().isGoal()) {
            status = GameService.endGame(game);;
        }
        // Se mueva o no el jugador se enviara al cliente la sala actual para que la pinte.
        req.setAttribute("gameJson", GameService.getGameJson(game, status));
        session.setAttribute("status", null);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/navigation.jsp");
        dispatcher.forward(req, resp);
    }

    private void error(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(401);
        req.setAttribute("error", "Dirección no valida.");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
        dispatcher.forward(req, resp);
    }

}
