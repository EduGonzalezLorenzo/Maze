package com.liceu.geom.model;

public class Door implements Side{
    private boolean status;
    private Room roomTo, roomFrom;

    public Door(Room roomTo, Room roomFrom) {
        this.roomTo = roomTo;
        this.roomFrom = roomFrom;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Room getRoomTo() {
        return roomTo;
    }

    public void setRoomTo(Room roomTo) {
        this.roomTo = roomTo;
    }

    public Room getRoomFrom() {
        return roomFrom;
    }

    public void setRoomFrom(Room roomFrom) {
        this.roomFrom = roomFrom;
    }

    @Override
    public void interactSide(Player player) {
        //Check si abierta
            //Si abierta ir a la habitación y return true

            //Si esta cerrada
                //Check si player tiene la llave
                    //Si la tiene abrir la puerta
                    //Si no la tiene avisar de que no la tiene
    }
}
