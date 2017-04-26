package br.com.alchemy.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import br.com.alchemy.model.IngredientObject;

public class Preferences {

    private static final String TAG = "tag";
    private static final String INGREDIENT_LIST = "ingredient_list";

    public static void saveIngredient(Context context, IngredientObject ingredient) {

        ArrayList<IngredientObject> ingredients = getIngredients(context);
        ingredients.add(ingredient);

        SharedPreferences shref;
        SharedPreferences.Editor editor;
        shref = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);

        Gson gson = new Gson();
        String json = gson.toJson(ingredients);

        editor = shref.edit();
        editor.remove(INGREDIENT_LIST).commit();
        editor.putString(INGREDIENT_LIST, json);
        editor.commit();
    }

    public static ArrayList<IngredientObject> getIngredients(Context context) {
        SharedPreferences shref;
        shref = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);

        Gson gson = new Gson();
        String response = shref.getString(INGREDIENT_LIST, "");
        ArrayList<IngredientObject> listArrayList = gson.fromJson(response, new TypeToken<List<IngredientObject>>() {
        }.getType());

        if (listArrayList == null){
            listArrayList = new ArrayList<>();
        }

        return listArrayList;
    }

    public static void clearIngredients(Context context){
        SharedPreferences shref;
        SharedPreferences.Editor editor;
        shref = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);

        editor = shref.edit();
        editor.remove(INGREDIENT_LIST).commit();
        editor.commit();
        Toast.makeText(context, "Os ingredientes apagados!", Toast.LENGTH_SHORT).show();
    }

}
