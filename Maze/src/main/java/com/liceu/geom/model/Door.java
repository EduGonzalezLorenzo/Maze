package com.liceu.geom.model;

public class Door implements Side{
    private boolean open;
    private Room roomTo, roomFrom;

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
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
