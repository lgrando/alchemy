package br.com.alchemy.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.alchemy.R;
import br.com.alchemy.adapter.IngredientListAdapter;
import br.com.alchemy.adapter.IngredientListItem;
import br.com.alchemy.model.IngredientObject;
import br.com.alchemy.util.Preferences;

public class MakePotionFragment extends Fragment {

    private ListView lvResult;
    private ArrayList<IngredientListItem> itens;
    private IngredientListAdapter ingredientListAdapter;

    public MakePotionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_make_potion, container, false);

        initViews(view);

        createListView(Preferences.getIngredients(getActivity()));
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
            itens.add(item);
            itens.add(item);
        }
        ingredientListAdapter = new IngredientListAdapter(getActivity(), itens);
        lvResult.setAdapter(ingredientListAdapter);
    }

    private void initViews(View view) {
        lvResult = (ListView) view.findViewById(R.id.lv_result);
    }

}
