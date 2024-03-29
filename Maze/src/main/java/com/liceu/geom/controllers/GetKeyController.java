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

        String status;
        try {
            //Se intenta coger llave. Si no hay se envia error al cliente.
            status = RoomService.giveKeyToPlayer(game);
        }catch (NoItemExepcition e){
            error(req, resp);
            return;
        }

        session.setAttribute("game", game);
        session.setAttribute("status", status);
        resp.sendRedirect("/nav");
    }

    private void error(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(401);
        req.setAttribute("error", "No hay llaves en esta habitación.");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
        dispatcher.forward(req, resp);
    }
}
