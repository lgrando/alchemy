package br.com.alchemy.util;


import java.util.ArrayList;
import java.util.Collections;

public class Constant {

    private static String[] EFFECTS = {
            "Ravage Magicka",
            "Fortify Magicka",
            "Ravage Stamina",
            "Slow",
            "Restore Magicka",
            "Damage Health",
            "Weakness to Poisson"};

    public static void sortEffectsArray() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String effect : EFFECTS) {
            arrayList.add(effect);
        }

        Collections.sort(arrayList);

        for (int i = 0; i < arrayList.size(); i++) {
            EFFECTS[i] = arrayList.get(i);
        }
    }

    public static String[] getEFFECTS(){
        sortEffectsArray();
        return EFFECTS;
    }
}
