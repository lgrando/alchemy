package br.com.alchemy.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import br.com.alchemy.R;
import br.com.alchemy.model.IngredientObject;
import br.com.alchemy.util.Preferences;

public class EditIngredientFragment extends Fragment {

    private Spinner spIngredients;

    public EditIngredientFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_ingredient, container, false);
        initViews(view);

        populateSpinner(spIngredients);
        return view;
    }

    private void initViews(View view) {
        spIngredients = (Spinner) view.findViewById(R.id.sp_ingredients);
        spIngredients.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    private void populateSpinner(Spinner spinner) {
        List<IngredientObject> ingredientList = Preferences.getIngredients(getActivity());
        List<String> listIngredientName = new ArrayList<>();
        for (IngredientObject ingredientObject : ingredientList) {
            listIngredientName.add(ingredientObject.getName());
        }

        listIngredientName.add(0, "Selecione...");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, listIngredientName);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

}
