package br.com.alchemy.model;

import java.io.Serializable;

public class Ingredient implements Serializable {

    private String name;
    private String firstEffect;
    private String secondEffect;
    private String thirdEffect;
    private String fourthEffect;
    private int price;

    public Ingredient(String name, String firstEffect, String secondEffect, String thirdEffect, String fourthEffect, int price) {
        this.name = name;
        this.firstEffect = firstEffect;
        this.secondEffect = secondEffect;
        this.thirdEffect = thirdEffect;
        this.fourthEffect = fourthEffect;
        this.price = price;
    }

    public Ingredient() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstEffect() {
        return firstEffect;
    }

    public void setFirstEffect(String firstEffect) {
        this.firstEffect = firstEffect;
    }

    public String getSecondEffect() {
        return secondEffect;
    }

    public void setSecondEffect(String secondEffect) {
        this.secondEffect = secondEffect;
    }

    public String getThirdEffect() {
        return thirdEffect;
    }

    public void setThirdEffect(String thirdEffect) {
        this.thirdEffect = thirdEffect;
    }

    public String getFourthEffect() {
        return fourthEffect;
    }

    public void setFourthEffect(String fourthEffect) {
        this.fourthEffect = fourthEffect;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
