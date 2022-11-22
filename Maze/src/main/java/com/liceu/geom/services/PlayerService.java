package com.liceu.geom.services;

import com.liceu.geom.DAO.DAOException;
import com.liceu.geom.DAO.WinnersDao;
import com.liceu.geom.DAO.WinnersDaoMySql;
import com.liceu.geom.model.*;

import java.util.Map;

public class PlayerService {
    public static Player generatePlayer(MazeMap mazeMap) {
        Player player = new Player();
        //Se busca la habitación de inicio y se le asigna como localización actual al jugador.
        for (Map.Entry<Integer, Room> entry : mazeMap.getRoomList().entrySet()) {
            Room room = entry.getValue();
            if (room.isStart()) {
                player.setLocation(room);
                return player;
            }
        }
        return null;
    }

    public static String movePlayer(Game game, String dir) {
        //Si la orientación no es valido devuelve error.
        if (SideService.getDirection(dir) == null) throw new NoValidDirException();
        // Con dirección valida el jugador intenta moverse en esa dirección
        Side.Directions direction = SideService.getDirection(dir);
        Player player = game.getPlayer();
        Room room = player.getLocation();
        Side roomSide = room.getSide(direction);
        return SideService.enterSide(player, roomSide);
    }

    public static void addPlayerToWinners(Game game, String playerName) {
        //Se da nombre al jugador y se intenta guardar en la base de datos
        Player player = game.getPlayer();
        player.setName(playerName);
        WinnersDao winnersDao = new WinnersDaoMySql();
        Winner winner = WinnerService.generateWinner(game);
        if(winnersDao.addToWinners(winner) == null) throw new DAOException();
        game.setVictory(false);
    }
}
