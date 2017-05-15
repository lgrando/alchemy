package br.com.alchemy.util;

import java.util.Comparator;

import br.com.alchemy.model.IngredientObject;

public class NameComparatorIngredient implements Comparator<IngredientObject> {

    @Override
    public int compare(IngredientObject o1, IngredientObject o2) {
        return o1.getName().compareTo(o2.getName());
    }

}
