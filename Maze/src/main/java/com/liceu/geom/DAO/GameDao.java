package com.liceu.geom.DAO;

import com.liceu.geom.model.Game;
import com.liceu.geom.model.MazeMap;
import com.liceu.geom.model.Player;

public interface GameDao {
    Game newGame(Player player, MazeMap mazeMap);
}
