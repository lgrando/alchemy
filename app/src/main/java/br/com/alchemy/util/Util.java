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
        effects.add(21,"Fortify One-Handed");
        effects.add(22,"Fortify Pickpocket");
        effects.add(23,"Fortify Restoration");
        effects.add(24,"Fortify Smithing");
        effects.add(25,"Fortify Sneak");
        effects.add(26,"Fortify Stamina");
        effects.add(27,"Fortify Two-Handed");
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

        addNewIngredientToList("Abecean Longfin","Weakness to Frost","Fortify Sneak","Weakness to Poison","Fortify Restoration",15);
        addNewIngredientToList("Ancestor Moth Wing","Damage Stamina","Fortify Conjuration","Damage Magicka Regen","Fortify Enchanting",2);
        addNewIngredientToList("Ash Creep Cluster","Damage Stamina","Invisibility","Resist Fire","Fortify Destruction",20);
        addNewIngredientToList("Ash Hopper Jelly","Restore Health","Fortify Light Armor","Resist Shock","Weakness to Frost",20);
        addNewIngredientToList("Ashen Grass Pod","Resist Fire","Weakness to Shock","Fortify Lockpicking","Fortify Sneak",1);
        addNewIngredientToList("Bear Claws","Restore Stamina","Fortify Health","Fortify One-Handed","Damage Magicka Regen",2);
        addNewIngredientToList("Bee","Restore Stamina","Ravage Stamina","Regenerate Stamina","Weakness to Shock",3);
        addNewIngredientToList("Beehive Husk","Resist Poison","Fortify Light Armor","Fortify Sneak","Fortify Destruction",5);
        addNewIngredientToList("Bleeding Crown","Weakness to Fire","Fortify Block","Weakness to Poison","Resist Magic",10);
        addNewIngredientToList("Blisterwort","Damage Stamina","Restore Health","Frenzy","Fortify Smithing",12);
        addNewIngredientToList("Blue Butterfly Wing","Damage Stamina","Damage Magicka Regen","Fortify Conjuration","Fortify Enchanting",2);
        addNewIngredientToList("Blue Dartwing","Resist Shock","Restore Health","Fortify Pickpocket","Fear",1);
        addNewIngredientToList("Blue Mountain Flower","Restore Health","Fortify Conjuration","Fortify Health","Damage Magicka Regen",2);
        addNewIngredientToList("Boar Tusk","Fortify Stamina","Fortify Health","Fortify Block","Frenzy",20);
        addNewIngredientToList("Bone Meal","Damage Stamina","Resist Fire","Fortify Conjuration","Ravage Stamina",5);
        addNewIngredientToList("Briar Heart","Restore Magicka","Fortify Block","Paralysis","Fortify Magicka",20);
        addNewIngredientToList("Burnt Spriggan Wood","Weakness to Fire","Fortify Alteration","Damage Magicka Regen","Slow",20);
        addNewIngredientToList("Butterfly Wing","Restore Health","Lingering Damage Stamina","Fortify Barter","Damage Magicka",3);
        addNewIngredientToList("Canis Root","Damage Stamina","Fortify Marksman","Fortify One-Handed","Paralysis",5);
        addNewIngredientToList("Charred Skeever Hide","Restore Stamina","Resist Poison","Cure Disease","Restore Health",1);
        addNewIngredientToList("Chaurus Eggs","Weakness to Poison","Fortify Stamina","Damage Magicka","Invisibility",10);
        addNewIngredientToList("Chaurus Hunter Antennae","Damage Stamina","Fortify Conjuration","Damage Magicka Regen","Fortify Enchanting",2);
        addNewIngredientToList("Chicken's Egg","Resist Magic","Waterbreathing","Damage Magicka Regen","Lingering Damage Stamina",2);
        addNewIngredientToList("Creep Cluster","Restore Magicka","Fortify Carry Weight","Damage Stamina Regen","Weakness to Magic",1);
        addNewIngredientToList("Crimson Nirnroot","Damage Health","Invisibility","Damage Stamina","Resist Magic",10);
        addNewIngredientToList("Cyrodilic Spadetail","Damage Stamina","Fear","Fortify Restoration","Ravage Health",15);
        addNewIngredientToList("Daedra Heart","Damage Stamina Regen","Damage Magicka","Restore Health","Fear",250);
        addNewIngredientToList("Deathbell","Damage Health","Ravage Stamina","Slow","Weakness to Poison",4);
        addNewIngredientToList("Dragon's Tongue","Resist Fire","Fortify Barter","Fortify Illusion","Fortify Two-Handed",5);
        addNewIngredientToList("Dwarven Oil","Weakness to Magic","Regenerate Magicka","Fortify Illusion","Restore Magicka",15);
        addNewIngredientToList("Ectoplasm","Restore Magicka","Fortify Destruction","Fortify Magicka","Damage Health",25);
        addNewIngredientToList("Elves Ear","Restore Magicka","Weakness to Frost","Fortify Marksman","Resist Fire",10);
        addNewIngredientToList("Emperor Parasol Moss","Damage Health","Fortify Magicka","Regenerate Health","Fortify Two-Handed",1);
        addNewIngredientToList("Eye of Sabre Cat","Restore Stamina","Damage Magicka","Ravage Health","Restore Health",2);
        addNewIngredientToList("Falmer Ear","Damage Health","Frenzy","Resist Poison","Fortify Lockpicking",10);
        addNewIngredientToList("Felsaad Tern Feathers","Restore Health","Fortify Light Armor","Cure Disease","Resist Magic",15);
        addNewIngredientToList("Fire Salts","Weakness to Frost","Restore Magicka","Resist Fire","Regenerate Magicka",50);
        addNewIngredientToList("Fly Amanita","Resist Fire","Frenzy","Fortify Two-Handed","Regenerate Stamina",2);
        addNewIngredientToList("Frost Mirriam","Resist Frost","Fortify Sneak","Ravage Magicka","Damage Stamina Regen",1);
        addNewIngredientToList("Frost Salts","Weakness to Fire","Resist Frost","Restore Magicka","Fortify Conjuration",100);
        addNewIngredientToList("Garlic","Resist Poison","Fortify Stamina","Regenerate Magicka","Regenerate Health",1);
        addNewIngredientToList("Giant Lichen","Ravage Health","Weakness to Poison","Weakness to Shock","Restore Magicka",5);
        addNewIngredientToList("Giant's Toe","Damage Stamina","Fortify Carry Weight","Fortify Health","Damage Stamina Regen",20);
        addNewIngredientToList("Gleamblossom","Resist Magic","Fear","Regenerate Health","Paralysis",5);
        addNewIngredientToList("Glow Dust","Damage Magicka","Fortify Destruction","Damage Magicka Regen","Resist Shock",20);
        addNewIngredientToList("Glowing Mushroom","Resist Shock","Fortify Destruction","Fortify Smithing","Fortify Health",5);
        addNewIngredientToList("Grass Pod","Resist Poison","Ravage Magicka","Fortify Alteration","Restore Magicka",1);
        addNewIngredientToList("Hagraven Claw","Resist Magic","Lingering Damage Magicka","Fortify Enchanting","Fortify Barter",20);
        addNewIngredientToList("Hagraven Feathers","Damage Magicka","Frenzy","Fortify Conjuration","Weakness to Shock",20);
        addNewIngredientToList("Hanging Moss","Damage Magicka","Damage Magicka Regen","Fortify Health","Fortify One-handed",1);
        addNewIngredientToList("Hawk Beak","Restore Stamina","Resist Frost","Fortify Carry Weight","Resist Shock",15);
        addNewIngredientToList("Hawk Feathers","Cure Disease","Fortify Light Armor","Fortify One-handed","Fortify Sneak",15);
        addNewIngredientToList("Hawk's Egg","Resist Magic","Damage Magicka Regen","Waterbreathing","Lingering Damage Stamina",2);
        addNewIngredientToList("Histcarp","Restore Stamina","Fortify Magicka","Damage Stamina Regen","Waterbreathing",6);
        addNewIngredientToList("Honeycomb","Restore Stamina","Fortify Block","Fortify Light Armor","Ravage Stamina",5);
        addNewIngredientToList("Human Flesh","Damage Health","Paralysis","Restore Magicka","Fortify Sneak",1);
        addNewIngredientToList("Human Heart","Damage Health","Damage Magicka Regen","Damage Magicka","Frenzy",0);
        addNewIngredientToList("Ice Wraith Teeth","Weakness to Frost","Fortify Heavy Armor","Invisibility","Weakness to Fire",30);
        addNewIngredientToList("Imp Stool","Damage Health","Paralysis","Lingering Damage Health","Restore Health",0);
        addNewIngredientToList("Jarrin Root","Damage Health","Damage Stamina","Damage Magicka","Damage Magicka Regen",10);
        addNewIngredientToList("Jazbay Grapes","Weakness to Magic","Fortify Magicka","Regenerate Magicka","Ravage Health",1);
        addNewIngredientToList("Juniper Berries","Weakness to Fire","Rengerate Health","Fortify Marksman","Damage Stamina Regen",1);
        addNewIngredientToList("Large Antlers","Restore Stamina","Fortify Stamina","Slow","Damage Stamina Regen",2);
        addNewIngredientToList("Lavender","Resist Magic","Fortify Stamina","Ravage Magicka","Fortify Conjuration",1);
        addNewIngredientToList("Luna Moth Wing","Damage Magicka","Fortify Light Armor","Rengenerate Health","Invisibility",5);
        addNewIngredientToList("Moon Sugar","Weakness to Fire","Resist Frost","Restore Magicka","Regenerate Magicka",50);
        addNewIngredientToList("Mora Tapinella","Restore Magicka","Lingering Damage Health","Regenerate Stamina","Fortify Illusion",4);
        addNewIngredientToList("Mudcrab Chitin","Restore Stamina","Cure Disease","Resist Poison","Resist Fire",2);
        addNewIngredientToList("Niamira's Rot","Damage Magicka","Fear","Fortify Lockpicking","Rengenerate Health",0);
        addNewIngredientToList("Netch Jelly","Paralysis","Fortify Carry Weight","Restore Stamina","Fear",20);
        addNewIngredientToList("Nightshade","Damage Health","Damage Magicka Regen","Lingering Damage Stamina","Fortify Destruction",8);
        addNewIngredientToList("Nirnroot","Damage Health","Damage Stamina","Invisibility","Resist Magic",10);
        addNewIngredientToList("Nordic Barnacle","Damage Magicka","Waterbreathing","Regenerate Health","Fortify Pickpocket",5);
        addNewIngredientToList("Orange Dartwing","Restore Stamina","Ravage Magicka","Fortify Pickpocket","Lingering Damage Health",1);
        addNewIngredientToList("Pearl","Restore Stamina","Restore Magicka","Fortify Block","Resist Shock",2);
        addNewIngredientToList("Pine Thrush Egg","Restore Stamina","Fortify Lockpicking","Weakness to Poison","Resist Shock",2);
        addNewIngredientToList("Poison Bloom","Damage Health","Slow","Fortify Carry Weight","Fear",5);
        addNewIngredientToList("Powdered Mammoth Tusk","Restore Stamina","Weakness to Fire","Fortify Sneak","Fear",2);
        addNewIngredientToList("Purple Mountain Flower","Restore Stamina","Fortify Sneak","Lingering Damage Magicka","Resist Frost",2);
        addNewIngredientToList("Red Mountain Flower","Restore Magicka","Ravage Magicka","Fortify Magicka","Damage Health",2);
        addNewIngredientToList("River Betty","Damage Health","Fortify Alteration","Slow","Fortify Carry Weight",15);
        addNewIngredientToList("Rock Warbler Egg","Restore Health","Fortify One-handed","Damage Stamina","Weakness to Magic",2);
        addNewIngredientToList("Sabre Cat Tooth","Restore Stamina","Fortify Heavy Armor","Fortify Smithing","Weakness to Poison",2);
        addNewIngredientToList("Salmon Roe","Restore Stamina","Waterbreathing","Fortify Magicka","Regenerate Magicka",5);
        addNewIngredientToList("Salt Pile","Weakness to Magic","Fortify Restoration","Slow","Regenerate Magicka",2);
        addNewIngredientToList("Scaly Pholiata","Weakness to Magic","Fortify Illusion","Regenerate Stamina","Fortify Carry Weight",4);
        addNewIngredientToList("Scathecraw","Ravage Health","Ravage Stamina","Ravage Magicka","Lingering Damage Health",1);
        addNewIngredientToList("Silverside Perch","Restore Stamina","Damage Stamina Regen","Ravage Health","Resist Frost",15);
        addNewIngredientToList("Skeever Tail","Damage Stamina Regen","Ravage Health","Damage Health","Fortify Light Armor",3);
        addNewIngredientToList("Slaughterfish Egg","Resist Poison","Fortify Pickpocket","Lingering Damage Health","Fortify Stamina",3);
        addNewIngredientToList("Slaughterfish Scales","Resist Frost","Lingering Damage Health","Fortify Heavy Armor","Fortify Block",3);
        addNewIngredientToList("Small Antlers","Weakness to Poison","Fortify Restoration","Lingering Damage Stamina","Damage Health",2);
        addNewIngredientToList("Small Pearl","Restore Stamina","Fortify One-handed","Fortify Restoration","Resist Frost",2);
        addNewIngredientToList("Snowberries","Resist Fire","Fortify Enchanting","Resist Frost","Resist Shock",4);
        addNewIngredientToList("Spawn Ash","Ravage Stamina","Resist Fire","Fortify Enchanting","Ravage Magicka",20);
        addNewIngredientToList("Spider Egg","Damage Stamina","Damage Magicka Regen","Fortify Lockpicking","Fortify Marksman",5);
        addNewIngredientToList("Spriggan Sap","Damage Magicka Regen","Fortify Enchanting","Fortify Smithing","Fortify Alteration",15);
        addNewIngredientToList("Swamp Fungal Pod","Resist Shock","Lingering Damage Magicka","Paralysis","Restore Health",5);
        addNewIngredientToList("Taproot","Weakness to Magic","Fortify Illusion","Regenerate Magicka","Restore Magicka",15);
        addNewIngredientToList("Thistle Branch","Resist Frost","Ravage Stamina","Resist Poison","Fortify Heavy Armor",1);
        addNewIngredientToList("Torchbug Thorax","Restore Stamina","Lingering Damage Magicka","Weakness to Magic","Fortify Stamina",1);
        addNewIngredientToList("Trama Root","Weakness to Shock","Fortify Carry Weight","Damage Magicka","Slow",1);
        addNewIngredientToList("Troll Fat","Resist Poison","Fortify Two-Handed","Frenzy","Damage Health",15);
        addNewIngredientToList("Tundra Cotton","Resist Magic","Fortify Magicka","Fortify Block","Fortify Barter",1);
        addNewIngredientToList("Vampire Dust","Invisibility","Regenerate Health","Restore Magicka","Cure Disease",25);
        addNewIngredientToList("Void Salts","Weakness to Shock","Resist Magic","Damage Health","Fortify Magicka",125);
        addNewIngredientToList("Wheat","Restore Health","Fortify Health","Damage Stamina Regen","Lingering Damage Magicka",5);
        addNewIngredientToList("White Cap","Weakness to Frost","Fortify Heavy Armor","Restore Magicka","Ravage Magicka",0);
        addNewIngredientToList("Wisp Wrappings","Restore Stamina","Fortify Destruction","Fortify Carry Weight","Resist Magic",2);
        addNewIngredientToList("Yellow Mountain Flower","Resist Poison","Fortify Restoration","Fortify Health","Damage Stamina Regen",2);

        Collections.sort(ingredients, new NameComparatorIngredient());
        return ingredients;
    }

    private static void addNewIngredientToList(String name, String first, String second, String third, String fourth, int price) {
        IngredientObject ingredientObject = new IngredientObject(name, first, second, third, fourth, price);
        ingredients.add(ingredientObject);
    }

}
