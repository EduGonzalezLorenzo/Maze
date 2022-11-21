package com.liceu.geom.controllers;

import com.liceu.geom.model.Game;
import com.liceu.geom.model.Player;
import com.liceu.geom.model.Room;
import com.liceu.geom.services.NoItemExepcition;
import com.liceu.geom.services.RoomService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/getkey")
public class GetKeyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Game game = (Game) session.getAttribute("game");
        Room room = game.getPlayer().getLocation();
        Player player = game.getPlayer();
        String status;
        try {
            status = RoomService.giveKeyToPlayer(room, player);
        }catch (NoItemExepcition e){
            resp.setStatus(401);
            req.setAttribute("error", "No hay llaves en esta habitación.");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
            dispatcher.forward(req, resp);
            return;
        }

        session.setAttribute("game", game);
        session.setAttribute("status", status);
        resp.sendRedirect("/nav");
    }
}
