package com.liceu.geom.controllers;

import com.liceu.geom.DAO.DAOException;
import com.liceu.geom.model.Game;
import com.liceu.geom.services.GameService;
import com.liceu.geom.services.PlayerService;

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
        //Se verifica que el usuario introduzca algo válidocomo nombre.
        if (playerName.trim().equals("")) {
            req.setAttribute("logError", "Introduce un nombre!");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/endform.jsp");
            dispatcher.forward(req, resp);
        } else {
            //Se guarda al ganador en la base de datos y se borra la partida.
            HttpSession session = req.getSession();
            Game game = (Game) session.getAttribute("game");
            try {
                PlayerService.addPlayerToWinners(game, playerName);
            } catch (DAOException e){
                error(req, resp);
                return;
            }
            req.setAttribute("gameJson", null);
            session.setAttribute("game", null);
            resp.sendRedirect("/winners");
        }
    }
    private void error(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(401);
        req.setAttribute("error", "No ha sido posible guardar el usuario en la base de datos.");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
        dispatcher.forward(req, resp);
    }
}
