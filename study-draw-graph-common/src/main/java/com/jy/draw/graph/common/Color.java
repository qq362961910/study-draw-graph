package com.jy.draw.graph.common;

public enum Color {

    BLACK((byte)1, "black");

    private byte value;
    private String name;

    Color(byte value, String name) {
        this.value = value;
        this.name = name;
    }

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
