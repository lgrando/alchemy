package br.com.alchemy.util;

import br.com.alchemy.model.Effect;
import br.com.alchemy.model.Ingredient;
import br.com.alchemy.model.Potion;

public class CustomComparator implements java.util.Comparator<Object> {

    @Override
    public int compare(Object o1, Object o2) {
        int result = 0;
        if (o1 instanceof Ingredient) {
            Ingredient i1 = (Ingredient) o1;
            Ingredient i2 = (Ingredient) o2;
            result = i1.getName().compareTo(i2.getName());
        } else if (o1 instanceof Potion) {
            Potion p1 = (Potion) o1;
            Potion p2 = (Potion) o2;
            result = p1.getDescription().compareTo(p2.getDescription());
        } else if (o1 instanceof Effect) {
            Effect e1 = (Effect) o1;
            Effect e2 = (Effect) o2;
            result = e1.getName().compareTo(e2.getName());
        }
        return result;
    }

}
