package com.liceu.geom.services;

import com.liceu.geom.DAO.*;
import com.liceu.geom.model.Game;
import com.liceu.geom.model.MazeMap;
import com.liceu.geom.model.Player;

public class GameService {
    GameDao gameDao = new GameDaoImpl();
    PlayerService playerService = new PlayerService();
    MazeMapService mazeMapService = new MazeMapService();

    public Game createNewGame(int mazeMapType) {
        MazeMap mazeMap = MazeMapService.generateMazeMap(mazeMapType);
        Player player = playerService.generatePlayer();
        return gameDao.newGame(player, mazeMap);
    }
}
