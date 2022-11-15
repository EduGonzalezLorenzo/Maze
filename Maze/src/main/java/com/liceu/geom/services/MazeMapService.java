package com.liceu.geom.services;

import com.liceu.geom.model.Coin;
import com.liceu.geom.model.DoorKey;
import com.liceu.geom.model.MazeMap;
import com.liceu.geom.model.Side;
import com.liceu.geom.utils.MazeMapBuilderImpl;

import java.util.stream.IntStream;

public class MazeMapService {

    public static MazeMap generateMazeMap(int mazeType) {
        return switch (mazeType) {
            case 1 -> createTutorialMaze();
            case 2 -> createNormalMaze();
            default -> null;
        };
    }

    public static MazeMap createTutorialMaze() {
        //Creación de habitaciones
        MazeMapBuilderImpl mazeMapBuilder = new MazeMapBuilderImpl();
        IntStream.range(1, 5).forEach(mazeMapBuilder::buildRoom);

        //Creación de puertas abiertas
        mazeMapBuilder.buildDoorWithKey(2, 3, Side.Directions.EAST);
        mazeMapBuilder.buildDoorWithKey(3, 4, Side.Directions.EAST);

        //Creación de items
        DoorKey key1 = new DoorKey();
        key1.setName("Key Goal Room");
        key1.setValue(1);
        Coin coin = new Coin();
        coin.setId(1);
        coin.setValue(1);

        //Asignación de items a habitaciones
        mazeMapBuilder.putCoinInRoom(4, coin);
        mazeMapBuilder.putKeyInRoom(3, key1);
        mazeMapBuilder.buildDoorWithKey(1, 2, Side.Directions.EAST, key1);

        //Asignación de salida y meta
        mazeMapBuilder.setStart(2);
        mazeMapBuilder.setGoal(1);

        return mazeMapBuilder.getMaze();
    }

    private static MazeMap createNormalMaze() {
        return null;
    }

}
