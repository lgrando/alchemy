package br.com.alchemy.model;

import java.io.Serializable;

public class Effect implements Serializable {

    private String name;
    private int value;

    public Effect(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public Effect() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
