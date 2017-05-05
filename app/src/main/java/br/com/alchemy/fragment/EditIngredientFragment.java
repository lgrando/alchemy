package br.com.alchemy.fragment;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.alchemy.R;
import br.com.alchemy.model.IngredientObject;
import br.com.alchemy.util.Preferences;

public class EditIngredientFragment extends Fragment {

    private Spinner spIngredients;
    private EditText etName;
    private EditText etPrice;
    private Spinner spFirstEffect;
    private Spinner spSecondEffect;
    private Spinner spThirdEffect;
    private Spinner spFourthEffect;
    private Button btnSave;
    private LinearLayout llIngredientDetail;
    private IngredientObject ingredientObject;

    public EditIngredientFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_ingredient, container, false);
        initViews(view);

        populateSpinnerIngredient(spIngredients);
        populateSpinnerEffect(spFirstEffect);
        populateSpinnerEffect(spSecondEffect);
        populateSpinnerEffect(spThirdEffect);
        populateSpinnerEffect(spFourthEffect);
        return view;
    }

    private void initViews(View view) {
        spIngredients = (Spinner) view.findViewById(R.id.sp_ingredients);
        spIngredients.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0 ) {
                    ingredientObject = Preferences.getIngredients().get(position - 1);
                    populateIngredientDetail(ingredientObject);
                } else {
                    llIngredientDetail.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        llIngredientDetail = (LinearLayout) view.findViewById(R.id.ll_ingredient_detail);
        etName = (EditText) view.findViewById(R.id.et_name);
        etPrice = (EditText) view.findViewById(R.id.et_price);
        spFirstEffect = (Spinner) view.findViewById(R.id.sp_first_effect);
        spSecondEffect = (Spinner) view.findViewById(R.id.sp_second_effect);
        spThirdEffect = (Spinner) view.findViewById(R.id.sp_third_effect);
        spFourthEffect = (Spinner) view.findViewById(R.id.sp_fourth_effect);

        btnSave = (Button) view.findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editIngredient();
            }
        });
    }

    private void populateIngredientDetail(IngredientObject ingredientObject){
        llIngredientDetail.setVisibility(View.VISIBLE);
        etName.setText(ingredientObject.getName());
        etPrice.setText(String.valueOf(ingredientObject.getPrice()));
        spFirstEffect.setSelection(((ArrayAdapter<String>)spFirstEffect.getAdapter()).getPosition(ingredientObject.getFirstEffect()));
        spSecondEffect.setSelection(((ArrayAdapter<String>)spSecondEffect.getAdapter()).getPosition(ingredientObject.getSecondEffect()));
        spThirdEffect.setSelection(((ArrayAdapter<String>)spThirdEffect.getAdapter()).getPosition(ingredientObject.getThirdEffect()));
        spFourthEffect.setSelection(((ArrayAdapter<String>)spFourthEffect.getAdapter()).getPosition(ingredientObject.getFourthEffect()));
    }


    private void populateSpinnerIngredient(Spinner spinner) {
        List<IngredientObject> ingredientList = Preferences.getIngredients();
        List<String> listIngredientName = new ArrayList<>();
        for (IngredientObject ingredientObject : ingredientList) {
            listIngredientName.add(ingredientObject.getName());
        }

        listIngredientName.add(0, "Selecione...");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, listIngredientName);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void populateSpinnerEffect(Spinner spinner) {
        List<String> effectList = new ArrayList<>();
        populateEffects(effectList);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, effectList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }

    private void populateEffects(List<String> list) {

        for (String effect : Preferences.getEffects()) {
            list.add(effect);
        }
        list.add(0, "Unknown");
    }

    private void editIngredient() {
        if (validadeEmptyFields() && validadeEffects()) {
            IngredientObject ingredient = new IngredientObject();
            ingredient.setName(etName.getText().toString().trim().toUpperCase());
            ingredient.setPrice(Integer.parseInt(etPrice.getText().toString()));
            ingredient.setFirstEffect(spFirstEffect.getSelectedItem().toString());
            ingredient.setSecondEffect(spSecondEffect.getSelectedItem().toString());
            ingredient.setThirdEffect(spThirdEffect.getSelectedItem().toString());
            ingredient.setFourthEffect(spFourthEffect.getSelectedItem().toString());

            Preferences.editIngredient(ingredientObject.getName(), ingredient);
            populateSpinnerIngredient(spIngredients);
            llIngredientDetail.setVisibility(View.GONE);
            Snackbar.make(btnSave, "Ingrediente editado!", Snackbar.LENGTH_LONG).setAction("Action", null).show();

        }
    }

    private boolean validateDuplicateIngredient(IngredientObject ingredient) {
        ArrayList<IngredientObject> ingredientList = Preferences.getIngredients();

        for (IngredientObject ingredientObject : ingredientList) {
            if (ingredient.getName().equalsIgnoreCase(ingredientObject.getName())) {
                return false;
            }
        }
        return true;
    }

    private boolean validadeEmptyFields() {
        if (etName.getText().toString().isEmpty()) {
            etName.setError("Campo obrigatório");
            return false;
        }
        if (etPrice.getText().toString().isEmpty()) {
            etPrice.setError("Campo obrigatório");
            return false;
        }
        etName.setError(null);
        etPrice.setError(null);
        return true;
    }

    private boolean validadeEffects() {
        String firstEffect = spFirstEffect.getSelectedItem().toString();
        String secondEffect = spSecondEffect.getSelectedItem().toString();
        String thirdEffect = spThirdEffect.getSelectedItem().toString();
        String fourthEffect = spFourthEffect.getSelectedItem().toString();

        if (!firstEffect.equalsIgnoreCase("Unknown")) {
            if (firstEffect.equalsIgnoreCase(secondEffect) || firstEffect.equalsIgnoreCase(thirdEffect) || firstEffect.equalsIgnoreCase(fourthEffect)) {
                etName.setError("Efeitos devem ser diferentes");
                return false;
            }
        }

        if (!secondEffect.equalsIgnoreCase("Unknown")) {
            if (secondEffect.equalsIgnoreCase(thirdEffect) || secondEffect.equalsIgnoreCase(fourthEffect)) {
                etName.setError("Efeitos devem ser diferentes");
                return false;
            }
        }

        if (!thirdEffect.equalsIgnoreCase("Unknown")) {
            if (thirdEffect.equalsIgnoreCase(fourthEffect)) {
                etName.setError("Efeitos devem ser diferentes");
                return false;
            }
        }

        etName.setError(null);
        return true;
    }

}
