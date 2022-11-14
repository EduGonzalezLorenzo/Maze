package com.liceu.geom.services;

import com.liceu.geom.model.DoorKey;
import com.liceu.geom.model.MazeMap;
import com.liceu.geom.model.Room;
import com.liceu.geom.model.Side;
import com.liceu.geom.utils.MazeMapBuilderImpl;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class MazeMapService {

    public static MazeMap generateMazeMap(int mazeType) {
        switch (mazeType) {
            case 1:
                return createTutorialMaze();
            case 2:
                return createMaze1();
            default:
                return null;
        }
    }

    public static MazeMap createTutorialMaze() {
        MazeMapBuilderImpl mazeMapBuilder = new MazeMapBuilderImpl();
        IntStream.range(1, 4).forEach(mazeMapBuilder::buildRoom);

        DoorKey key1 = new DoorKey();

        mazeMapBuilder.buildDoor(1, 2, Side.Directions.NORTH);
        mazeMapBuilder.buildDoor(1, 4, Side.Directions.SOUTH);
        mazeMapBuilder.buildDoor(1, 5, Side.Directions.EAST);

        mazeMapBuilder.buildDoor(5, 6, Side.Directions.EAST, key1);


        mazeMapBuilder.setGoal(3);

        return mazeMapBuilder.getMaze();
    }

    private static MazeMap createMaze1() {
        return null;
    }

}
