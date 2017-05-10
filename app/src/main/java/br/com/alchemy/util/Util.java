package br.com.alchemy.util;

import java.util.ArrayList;
import java.util.Collections;

import br.com.alchemy.model.IngredientObject;

public class Util {

    public static ArrayList<String> effects;
    public static ArrayList<IngredientObject> ingredients;

    public static String initcaps(String string) {
        return Character.toUpperCase(string.charAt(0)) + string.substring(1);
    }

    public static ArrayList<String> getEffects() {
        effects = new ArrayList<>();

        effects.add(0,"Cure Disease");
        effects.add(1,"Damage Health");
        effects.add(2,"Damage Magicka");
        effects.add(3,"Damage Magicka Regen");
        effects.add(4,"Damage Stamina");
        effects.add(5,"Damage Stamina Regen");
        effects.add(6,"Fear");
        effects.add(7,"Fortify Alteration");
        effects.add(8,"Fortify Barter");
        effects.add(9,"Fortify Block");
        effects.add(10,"Fortify Carry Weight");
        effects.add(11,"Fortify Conjuration");
        effects.add(12,"Fortify Destruction");
        effects.add(13,"Fortify Enchanting");
        effects.add(14,"Fortify Health");
        effects.add(15,"Fortify Heavy Armor");
        effects.add(16,"Fortify Illusion");
        effects.add(17,"Fortify Light Armor");
        effects.add(18,"Fortify Lockpicking");
        effects.add(19,"Fortify Magicka");
        effects.add(20,"Fortify Marksman");
        effects.add(21,"Fortify One-handed");
        effects.add(22,"Fortify Pickpocket");
        effects.add(23,"Fortify Restoration");
        effects.add(24,"Fortify Smithing");
        effects.add(25,"Fortify Sneak");
        effects.add(26,"Fortify Stamina");
        effects.add(27,"Fortify Two-handed");
        effects.add(28,"Frenzy");
        effects.add(29,"Invisibility");
        effects.add(30,"Lingering Damage Health");
        effects.add(31,"Lingering Damage Magicka");
        effects.add(32,"Lingering Damage Stamina");
        effects.add(33,"Paralysis");
        effects.add(34,"Ravage Health");
        effects.add(35,"Ravage Magicka");
        effects.add(36,"Ravage Stamina");
        effects.add(37,"Regenerate Health");
        effects.add(38,"Regenerate Magicka");
        effects.add(39,"Regenerate Stamina");
        effects.add(40,"Resist Fire");
        effects.add(41,"Resist Frost");
        effects.add(42,"Resist Magic");
        effects.add(43,"Resist Poison");
        effects.add(44,"Resist Shock");
        effects.add(45,"Restore Health");
        effects.add(46,"Restore Magicka");
        effects.add(47,"Restore Stamina");
        effects.add(48,"Slow");
        effects.add(49,"Waterbreathing");
        effects.add(50,"Weakness to Fire");
        effects.add(51,"Weakness to Frost");
        effects.add(52,"Weakness to Magic");
        effects.add(53,"Weakness to Poison");
        effects.add(54,"Weakness to Shock");

        Collections.sort(effects);
        return effects;
    }

    public static ArrayList<IngredientObject> getIngredients() {
        ingredients = new ArrayList<>();

        IngredientObject deathbell = new IngredientObject("Deathbell", getEffects().get(1), getEffects().get(36), getEffects().get(48), getEffects().get(53), 4);

        return ingredients;
    }

}
