package com.liceu.geom.model;

public interface Side {
    enum Directions {
        NORTH,
        SOUTH,
        EAST,
        WEST
    }
    String interactSide(Player player);
}
