package br.com.alchemy.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.alchemy.R;
import br.com.alchemy.adapter.IngredientListAdapter;
import br.com.alchemy.adapter.IngredientListItem;
import br.com.alchemy.model.IngredientObject;
import br.com.alchemy.util.Preferences;
import br.com.alchemy.util.Util;

public class MakePotionFragment extends Fragment {

    private Button btnChoose;
    private ListView lvResult;
    private TextView tvSelected;
    private ArrayList<IngredientListItem> itens;
    private String[] effects;
    private ArrayList<Integer> list;
    int[] selectedItens;
    private IngredientListAdapter ingredientListAdapter;

    public MakePotionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_make_potion, container, false);

        castEffectsArray();
        initViews(view);
        list = new ArrayList<>();

//        createListView(Preferences.getIngredients(getActivity()));
        return view;
    }

    private void castEffectsArray() {
        List<String> effectsList = Preferences.getEffects();
        effects = new String[effectsList.size()];
        for (int i = 0; i < Preferences.getEffects().size(); i++) {
            effects[i] = Preferences.getEffects().get(i);
        }
    }

    private void createListView(ArrayList<IngredientObject> ingredients) {
        itens = new ArrayList<>();

        for (IngredientObject ingredient : ingredients) {
            IngredientListItem item = new IngredientListItem(
                    ingredient.getName(),
                    ingredient.getFirstEffect(),
                    ingredient.getSecondEffect(),
                    ingredient.getThirdEffect(),
                    ingredient.getFourthEffect(),
                    ingredient.getPrice()
            );
            itens.add(item);
        }
        ingredientListAdapter = new IngredientListAdapter(getActivity(), itens);
        lvResult.setAdapter(ingredientListAdapter);
    }

    private void initViews(View view) {
        btnChoose = (Button) view.findViewById(R.id.btn_choose);
        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMultipleChoiceDialog();
            }
        });
        lvResult = (ListView) view.findViewById(R.id.lv_result);
        tvSelected = (TextView) view.findViewById(R.id.tv_selected);
    }

    private void openMultipleChoiceDialog() {
        boolean[] isSelectedArray = new boolean[Preferences.getEffects().size()];
        populateCheckedItens(isSelectedArray);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Select effects")
                .setMultiChoiceItems(effects, isSelectedArray,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                if (isChecked) {
                                    if (!list.contains(which)) {
                                        list.add(which);
                                    }
                                } else if (list.contains(which)) {
                                    list.remove(Integer.valueOf(which));
                                }
                            }
                        })
                .setPositiveButton("Search", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        onOkay(list, true);
                    }
                })
                .setNeutralButton("Specific", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        onOkay(list, false);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onCancel(dialog);
                    }
                });

        builder.show();

    }

    private void populateCheckedItens(boolean[] isSelectedArray) {
        for (int index : list) {
            for (int i = 0; i < isSelectedArray.length; i++) {
                if (index == i) {
                    isSelectedArray[i] = true;
                    continue;
                }
            }
        }
    }

    public void onOkay(ArrayList<Integer> arrayList, boolean searchAll) {
        saveSelectedItens(arrayList);
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> selectedEffects = new ArrayList<>();
        if (arrayList.size() != 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                String effect = effects[arrayList.get(i)];
                stringBuilder = stringBuilder.append(effect + ", ");
                selectedEffects.add(effect);
            }
            searchIngredients(selectedEffects, searchAll);

            tvSelected.setText("Selected: " + stringBuilder.toString().substring(0, (stringBuilder.toString().length() - 2)));
        } else {
            createListView(new ArrayList<IngredientObject>());
            tvSelected.setText("No effects selected");
        }
    }

    public void onCancel(DialogInterface dialog) {
        dialog.dismiss();
    }

    private void searchIngredients(ArrayList<String> selectedEffects, boolean searchAll) {
        if (searchAll) {
            searchAllIngredients(selectedEffects);
        } else {
            searchSpecificIngredients(selectedEffects);
        }
    }

    private void searchAllIngredients(ArrayList<String> selectedEffects) {
        ArrayList<IngredientObject> ingredientsFound = new ArrayList<>();
        for (String effect : selectedEffects) {
            for (IngredientObject ingredient : Util.getIngredients()) {
                if (ingredient.getFirstEffect().equalsIgnoreCase(effect) ||
                        ingredient.getSecondEffect().equalsIgnoreCase(effect) ||
                        ingredient.getThirdEffect().equalsIgnoreCase(effect) ||
                        ingredient.getFourthEffect().equalsIgnoreCase(effect)) {
                    if (!isDuplicateIngredient(ingredientsFound, ingredient)) {
                        ingredientsFound.add(ingredient);
                    }
                }
            }
        }
        createListView(ingredientsFound);
    }

    //"slow"

    //--deathbell--
    //damage health
    //ravage stamina
    //slow
    //poison
    private void searchSpecificIngredients(ArrayList<String> selectedEffects) {
        ArrayList<IngredientObject> ingredientsFound = new ArrayList<>();
        int effectsCount = selectedEffects.size();
        int count;
        for (IngredientObject ingredient : Util.getIngredients()) {
            count = 0;
            for (String effect : selectedEffects) {
                if (ingredient.getFirstEffect().equalsIgnoreCase(effect) ||
                        ingredient.getSecondEffect().equalsIgnoreCase(effect) ||
                        ingredient.getThirdEffect().equalsIgnoreCase(effect) ||
                        ingredient.getFourthEffect().equalsIgnoreCase(effect)) {
                    if (!isDuplicateIngredient(ingredientsFound, ingredient)) {
                        count++;
                    }
                }
            }
            if (count == effectsCount) {
                ingredientsFound.add(ingredient);
            }
        }
        createListView(ingredientsFound);
    }

    private void saveSelectedItens(ArrayList<Integer> arrayList) {
        selectedItens = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            selectedItens[i] = arrayList.get(i);
        }
    }

    private boolean isDuplicateIngredient(ArrayList<IngredientObject> ingredientsFound, IngredientObject ingredient) {
        for (IngredientObject ingredientObj : ingredientsFound) {
            if (ingredient.getName().equalsIgnoreCase(ingredientObj.getName())) {
                return true;
            }
        }
        return false;
    }
}
