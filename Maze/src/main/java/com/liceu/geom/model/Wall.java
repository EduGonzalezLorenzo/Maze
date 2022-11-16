package com.liceu.geom.model;

public class Wall implements Side{
    @Override
    public String interactSide(Player player) {
        return "No puedes entrar por un muro";
    }

    @Override
    public String toString() {
        return "wall";
    }
}
