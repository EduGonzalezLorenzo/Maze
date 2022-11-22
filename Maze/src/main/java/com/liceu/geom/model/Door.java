package com.liceu.geom.model;

public class Door implements Side{
    private boolean open = true;
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
    public String toString() {
        return this.open ? "Open door" : "Close door";
    }
}
