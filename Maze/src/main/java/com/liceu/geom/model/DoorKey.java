package com.liceu.geom.model;

public class DoorKey implements Item{
    int id;
    Door door;

    int value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Door getDoor() {
        return door;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
