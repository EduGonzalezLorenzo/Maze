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
        mazeMapBuilder.buildDoor(2, 3, Side.Directions.EAST);
        mazeMapBuilder.buildDoor(3, 4, Side.Directions.EAST);

        //Creación de items
        DoorKey key1 = new DoorKey();
        key1.setName("Llave final");
        key1.setValue(2);
        Coin coin = new Coin();
        coin.setId(1);
        coin.setValue(1);
        Coin coin1 = new Coin();
        coin.setId(2);
        coin.setValue(1);

        //Asignación de items a habitaciones
        mazeMapBuilder.putCoinInRoom(4, coin);
        mazeMapBuilder.putCoinInRoom(3, coin1);
        mazeMapBuilder.putKeyInRoom(3, key1);

        //Creación de puertas cerradas (requieren llave)
        mazeMapBuilder.buildDoorWithKey(1, 2, Side.Directions.EAST, key1);

        //Asignación de salida y meta
        mazeMapBuilder.setStart(2);
        mazeMapBuilder.setGoal(1);

        mazeMapBuilder.setName("Tutorial");

        return mazeMapBuilder.getMaze();
    }

    private static MazeMap createNormalMaze() {
        //Creación de habitaciones
        MazeMapBuilderImpl mazeMapBuilder = new MazeMapBuilderImpl();
        IntStream.range(1, 7).forEach(mazeMapBuilder::buildRoom);

        //Creación de puertas abiertas
        mazeMapBuilder.buildDoor(3, 4, Side.Directions.EAST);
        mazeMapBuilder.buildDoor(4, 5, Side.Directions.EAST);

        //Creación de items
        DoorKey key1 = new DoorKey();
        key1.setName("Llave final");
        key1.setValue(2);
        DoorKey key2 = new DoorKey();
        key2.setName("Llave sur");
        key2.setValue(1);
        DoorKey key3 = new DoorKey();
        key3.setName("Llave norte");
        key3.setValue(1);

        Coin coin1 = new Coin();
        coin1.setId(1);
        coin1.setValue(1);
        Coin coin2 = new Coin();
        coin2.setId(2);
        coin2.setValue(1);
        Coin coin3 = new Coin();
        coin3.setId(3);
        coin3.setValue(1);
        Coin coin4 = new Coin();
        coin4.setId(4);
        coin4.setValue(1);

        //Asignación de items a habitaciones
        mazeMapBuilder.putCoinInRoom(1, coin1);
        mazeMapBuilder.putCoinInRoom(3, coin2);
        mazeMapBuilder.putCoinInRoom(4, coin3);
        mazeMapBuilder.putCoinInRoom(5, coin4);

        mazeMapBuilder.putKeyInRoom(6, key1);
        mazeMapBuilder.putKeyInRoom(1, key2);
        mazeMapBuilder.putKeyInRoom(4, key3);

        //Creación de puertas cerradas (requieren llave)
        mazeMapBuilder.buildDoorWithKey(2, 3, Side.Directions.EAST, key1);
        mazeMapBuilder.buildDoorWithKey(1, 3, Side.Directions.SOUTH, key3);
        mazeMapBuilder.buildDoorWithKey(3, 6, Side.Directions.SOUTH, key2);

        //Asignación de salida y meta
        mazeMapBuilder.setStart(3);
        mazeMapBuilder.setGoal(2);

        mazeMapBuilder.setName("Normal");

        return mazeMapBuilder.getMaze();
    }

}
