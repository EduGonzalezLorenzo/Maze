package com.liceu.geom.services;

import com.liceu.geom.DAO.MazeDaoImpl;
import com.liceu.geom.DAO.MazeMapDao;
import com.liceu.geom.model.MazeMap;

public class MazeMapService {
    MazeMapDao mazeMapDao = new MazeDaoImpl();

    public MazeMap getMazeMap(int mazeMapID) {
        switch (mazeMapID){
            case 1:

                return new MazeMap("Principiante");
            case 2:
                 return new MazeMap("Intermedio");
            case 3:
                return new MazeMap("Experto");
            default:
                return null;
        }
    }
}
