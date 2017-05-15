package br.com.alchemy.model;

import java.io.Serializable;

public class Potion implements Serializable {

    private String description;
    private String firstIngredient;
    private String secondIngredient;
    private String optionalIngredient;

    public Potion() {
    }

    public Potion(String description, String firstIngredient, String secondIngredient, String optionalIngredient) {
        this.description = description;
        this.firstIngredient = firstIngredient;
        this.secondIngredient = secondIngredient;
        this.optionalIngredient = optionalIngredient;
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
}
