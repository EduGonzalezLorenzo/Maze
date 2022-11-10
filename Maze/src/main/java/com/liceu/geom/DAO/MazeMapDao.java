package com.liceu.geom.DAO;

import com.liceu.geom.model.MazeMap;

public interface MazeMapDao {
    boolean startGame(MazeMap mazeMap);
    boolean endGame();
}
