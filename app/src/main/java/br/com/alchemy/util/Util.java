package br.com.alchemy.util;

import java.util.ArrayList;
import java.util.Collections;

public class Util {

    public static ArrayList<String> effects;

    public static String initcaps(String string) {
        return Character.toUpperCase(string.charAt(0)) + string.substring(1);
    }

    public static ArrayList<String> getEffects() {
        effects = new ArrayList<>();

        effects.add("Cure Disease");
        effects.add("Damage Health");
        effects.add("Damage Magicka");
        effects.add("Damage Magicka Regen");
        effects.add("Damage Stamina");
        effects.add("Damage Stamina Regen");
        effects.add("Fear");
        effects.add("Fortify Alteration");
        effects.add("Fortify Barter");
        effects.add("Fortify Block");
        effects.add("Fortify Carry Weight");
        effects.add("Fortify Conjuration");
        effects.add("Fortify Destruction");
        effects.add("Fortify Enchanting");
        effects.add("Fortify Health");
        effects.add("Fortify Heavy Armor");
        effects.add("Fortify Illusion");
        effects.add("Fortify Light Armor");
        effects.add("Fortify Lockpicking");
        effects.add("Fortify Magicka");
        effects.add("Fortify Marksman");
        effects.add("Fortify One-handed");
        effects.add("Fortify Pickpocket");
        effects.add("Fortify Restoration");
        effects.add("Fortify Smithing");
        effects.add("Fortify Sneak");
        effects.add("Fortify Stamina");
        effects.add("Fortify Two-handed");
        effects.add("Frenzy");
        effects.add("Invisibility");
        effects.add("Lingering Damage Health");
        effects.add("Lingering Damage Magicka");
        effects.add("Lingering Damage Stamina");
        effects.add("Paralysis");
        effects.add("Ravage Health");
        effects.add("Ravage Magicka");
        effects.add("Ravage Stamina");
        effects.add("Regenerate Health");
        effects.add("Regenerate Magicka");
        effects.add("Regenerate Stamina");
        effects.add("Resist Fire");
        effects.add("Resist Frost");
        effects.add("Resist Magic");
        effects.add("Resist Poison");
        effects.add("Resist Shock");
        effects.add("Restore Health");
        effects.add("Restore Magicka");
        effects.add("Restore Stamina");
        effects.add("Slow");
        effects.add("Waterbreathing");
        effects.add("Weakness to Fire");
        effects.add("Weakness to Frost");
        effects.add("Weakness to Magic");
        effects.add("Weakness to Poison");
        effects.add("Weakness to Shock");

        Collections.sort(effects);
        return effects;
    }

}
