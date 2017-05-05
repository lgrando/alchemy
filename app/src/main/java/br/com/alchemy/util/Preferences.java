package br.com.alchemy.util;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.alchemy.model.IngredientObject;

public class Preferences {

    private static final String TAG = "tag";
    public static String INGREDIENT_LIST = "ingredient_list";
    public static String EFFECT_LIST = "effect_list";
    public static Application application;
    private static Preferences preferences = new Preferences();

    public static void init(Application context) {
        application = context;
    }

    public static Preferences getInstance() {
        if (preferences == null) {
            preferences = new Preferences();
        }
        return preferences;
    }

    public static void saveIngredient(IngredientObject ingredient) {

        ArrayList<IngredientObject> ingredients = getIngredients();
        ingredients.add(ingredient);

        SharedPreferences shref;
        SharedPreferences.Editor editor;
        shref = application.getSharedPreferences(TAG, Context.MODE_PRIVATE);

        Gson gson = new Gson();
        String json = gson.toJson(ingredients);

        editor = shref.edit();
        editor.remove(INGREDIENT_LIST).commit();
        editor.putString(INGREDIENT_LIST, json);
        editor.commit();
    }

    public static void saveEffect(String effect) {

        ArrayList<String> effects = getEffects();
        effects.add(effect);

        SharedPreferences shref;
        SharedPreferences.Editor editor;
        shref = application.getSharedPreferences(TAG, Context.MODE_PRIVATE);

        Gson gson = new Gson();
        String json = gson.toJson(effects);

        editor = shref.edit();
        editor.remove(EFFECT_LIST).commit();
        editor.putString(EFFECT_LIST, json);
        editor.commit();
    }

    public static void editIngredient(String editIngredient, IngredientObject newIngredient) {
        ArrayList<IngredientObject> ingredients = getIngredients();

        for (int i = 0; i < ingredients.size(); i++) {
            if (editIngredient.equalsIgnoreCase(ingredients.get(i).getName())) {
                ingredients.remove(i);
            }
        }
        SharedPreferences shref;
        SharedPreferences.Editor editor;
        shref = application.getSharedPreferences(TAG, Context.MODE_PRIVATE);

        Gson gson = new Gson();
        String json = gson.toJson(ingredients);

        editor = shref.edit();
        editor.remove(INGREDIENT_LIST).commit();
        editor.putString(INGREDIENT_LIST, json);
        editor.commit();
        saveIngredient(newIngredient);
    }

    public static ArrayList<IngredientObject> getIngredients() {
        SharedPreferences shref;
        shref = application.getSharedPreferences(TAG, Context.MODE_PRIVATE);

        Gson gson = new Gson();
        String response = shref.getString(INGREDIENT_LIST, "");
        ArrayList<IngredientObject> listArrayList = gson.fromJson(response, new TypeToken<List<IngredientObject>>() {
        }.getType());

        if (listArrayList == null) {
            listArrayList = new ArrayList<>();
        }

        return listArrayList;
    }

    public static ArrayList<String> getEffects() {
        SharedPreferences shref;
        shref = application.getSharedPreferences(TAG, Context.MODE_PRIVATE);

        Gson gson = new Gson();
        String response = shref.getString(EFFECT_LIST, "");
        ArrayList<String> listArrayList = gson.fromJson(response, new TypeToken<List<String>>() {
        }.getType());

        if (listArrayList == null) {
            listArrayList = new ArrayList<>();
        }

        Collections.sort(listArrayList);
        return listArrayList;
    }

    public static void clearList(String key) {
        SharedPreferences shref;
        SharedPreferences.Editor editor;
        shref = application.getSharedPreferences(TAG, Context.MODE_PRIVATE);

        editor = shref.edit();
        editor.remove(key).commit();
        editor.commit();
    }
}
