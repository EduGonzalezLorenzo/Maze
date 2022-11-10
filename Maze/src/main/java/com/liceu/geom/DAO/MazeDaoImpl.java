package com.liceu.geom.DAO;


import com.liceu.geom.model.MazeMap;

import java.util.ArrayList;
import java.util.List;

public class MazeDaoImpl implements MazeMapDao {
    static List<MazeMap> activeMazeMaps = new ArrayList<>();
    static int idActiveMazeMap = 0;

    @Override
    public boolean startGame(MazeMap mazeMap) {
        mazeMap.setId(idActiveMazeMap);
        idActiveMazeMap++;
        activeMazeMaps.add(mazeMap);
        return true;
    }

    @Override
    public boolean endGame() {
        return false;
    }
}
