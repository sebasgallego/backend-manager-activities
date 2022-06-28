package com.gallego.manager.ctivities.activity.data;

public enum StatusMessage {

    PENDING("Sin empleado asignado"),

    ASSIGNED("Confirmación fecha de inicio"),

    ACTIVATE("En curso"),

    FINISHED("Actividad finalizada");

    private String value;

    StatusMessage(String s) {
        value = s;
    }

    public String getValue() {
        return value;
    }

}
