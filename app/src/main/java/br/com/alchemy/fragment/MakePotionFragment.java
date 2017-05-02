package br.com.alchemy.fragment;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.alchemy.R;
import br.com.alchemy.adapter.IngredientListAdapter;
import br.com.alchemy.adapter.IngredientListItem;
import br.com.alchemy.model.IngredientObject;
import br.com.alchemy.util.Constant;
import br.com.alchemy.util.MultipleChoiceListDialogListener;
import br.com.alchemy.util.Preferences;

import static br.com.alchemy.util.Constant.getEFFECTS;

public class MakePotionFragment extends Fragment implements MultipleChoiceListDialogListener {

    private Button btnChoose;
    private ListView lvResult;
    private TextView tvSelected;
    private ArrayList<IngredientListItem> itens;
    private ArrayList<Integer> list;
    int[] selectedItens;
    private IngredientListAdapter ingredientListAdapter;

    public MakePotionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_make_potion, container, false);

        initViews(view);
        list = new ArrayList<>();

//        createListView(Preferences.getIngredients(getActivity()));
        return view;
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
        boolean[] isSelectedArray = new boolean[getEFFECTS().length];
        populateCheckedItens(isSelectedArray);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Selecione os efeitos")
                .setMultiChoiceItems(getEFFECTS(), isSelectedArray,
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
                .setPositiveButton("Buscar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        onOkay(list);
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
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

    @Override
    public void onOkay(ArrayList<Integer> arrayList) {
        saveSelectedItens(arrayList);
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> selectedEffects = new ArrayList<>();
        if (arrayList.size() != 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                String effect = getEFFECTS()[arrayList.get(i)];
                stringBuilder = stringBuilder.append(" "+effect+", ");
                selectedEffects.add(effect);
            }
            searchIngredients(selectedEffects);

            tvSelected.setText("Selecionados: "+stringBuilder.toString().substring(0,(stringBuilder.toString().length()-2)));
        } else {
            createListView(new ArrayList<IngredientObject>());
            tvSelected.setText("Nenhum efeito selecionado");
        }
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        dialog.dismiss();
    }

    private void searchIngredients(ArrayList<String> selectedEffects) {
        ArrayList<IngredientObject> ingredientsFound = new ArrayList<>();
        for (String effect : selectedEffects) {
            for (IngredientObject ingredient : Preferences.getIngredients(getActivity())) {
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

    private void saveSelectedItens(ArrayList<Integer> arrayList) {
        selectedItens = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            selectedItens[i] = arrayList.get(i);
        }
    }

    private boolean isDuplicateIngredient(ArrayList<IngredientObject> ingredientsFound, IngredientObject ingredient) {
        for (IngredientObject ingredientObj : ingredientsFound) {
            if(ingredient.getName().equalsIgnoreCase(ingredientObj.getName())){
                return true;
            }
        }
        return false;
    }
}
