package com.liceu.geom.DAO;

import com.liceu.geom.model.Game;
import com.liceu.geom.model.MazeMap;
import com.liceu.geom.model.Player;

public class GameDaoImpl implements GameDao{
    static int gameID = 0;

    @Override
    public Game newGame(Player player, MazeMap mazeMap) {
        MazeMapDao mazeMapDao = new MazeMapDaoImpl();
        player.setLocation(mazeMapDao.getStartRoom(mazeMap));
        Game game = new Game();
        game.setPlayer(player);
        game.setMazeMap(mazeMap);
        game.setId(gameID);
        gameID++;
        return game;
    }
}
