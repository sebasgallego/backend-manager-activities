package com.gallego.manager.ctivities.activity.data;

public enum Status {
    PENDING(0),
    ASSIGNED(1),
    ACTIVATE(2),

    FINISHED(3);

    private int value;

    Status(int s) {
        value = s;
    }

    public int getValue() {
        return value;
    }

}
