package br.com.alchemy.Model;

public class IngredientObject {

    private String name;
    private String firstEffect;
    private String secondEffect;
    private String thirdEffect;
    private String fourthEffect;
    private double price;

    public IngredientObject(String name, String firstEffect, String secondEffect, String thirdEffect, String fourthEffect, double price) {
        this.name = name;
        this.firstEffect = firstEffect;
        this.secondEffect = secondEffect;
        this.thirdEffect = thirdEffect;
        this.fourthEffect = fourthEffect;
        this.price = price;
    }

    public IngredientObject() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
