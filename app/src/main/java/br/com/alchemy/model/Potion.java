package br.com.alchemy.model;

import java.io.Serializable;

public class Potion implements Serializable {

    private String description;
    private String firstIngredient;
    private String secondIngredient;
    private String optionalIngredient;
    private boolean expensive;
    private boolean strong;

    public Potion() {
    }

    public Potion(String description, String firstIngredient, String secondIngredient, String optionalIngredient, boolean expensive, boolean strong) {
        this.description = description;
        this.firstIngredient = firstIngredient;
        this.secondIngredient = secondIngredient;
        this.optionalIngredient = optionalIngredient;
        this.expensive = expensive;
        this.strong = strong;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFirstIngredient() {
        return firstIngredient;
    }

    public void setFirstIngredient(String firstIngredient) {
        this.firstIngredient = firstIngredient;
    }

    public String getSecondIngredient() {
        return secondIngredient;
    }

    public void setSecondIngredient(String secondIngredient) {
        this.secondIngredient = secondIngredient;
    }

    public String getOptionalIngredient() {
        return optionalIngredient;
    }

    public void setOptionalIngredient(String optionalIngredient) {
        this.optionalIngredient = optionalIngredient;
    }

    public boolean isExpensive() {
        return expensive;
    }

    public void setExpensive(boolean expensive) {
        this.expensive = expensive;
    }

    public boolean isStrong() {
        return strong;
    }

    public void setStrong(boolean strong) {
        this.strong = strong;
    }
}
