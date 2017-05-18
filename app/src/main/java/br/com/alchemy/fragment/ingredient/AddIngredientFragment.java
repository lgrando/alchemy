package br.com.alchemy.fragment.ingredient;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import br.com.alchemy.R;
import br.com.alchemy.model.Ingredient;
import br.com.alchemy.util.Preferences;

public class AddIngredientFragment extends Fragment {

    private EditText etName;
    private EditText etPrice;
    private Spinner spFirstEffect;
    private Spinner spSecondEffect;
    private Spinner spThirdEffect;
    private Spinner spFourthEffect;
    private Button btnSave;

    public AddIngredientFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_ingredient, container, false);

        getActivity().setTitle("Add ingredient");

        initViews(view);

        populateSpinner(spFirstEffect);
        populateSpinner(spSecondEffect);
        populateSpinner(spThirdEffect);
        populateSpinner(spFourthEffect);

        return view;
    }

    private void initViews(View view) {
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
                saveNewIngredient();
            }
        });

    }

    private void populateSpinner(Spinner spinner) {
        List<String> effectList = new ArrayList<>();
        populateEffects(effectList);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, effectList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }

    private void populateEffects(List<String> list) {
        List<String> effectsList = Preferences.getEffects();
        for (String effect : effectsList) {
            list.add(effect);
        }
        list.add(0, "Unknown");
    }

    private void saveNewIngredient() {
        if (validadeEmptyFields() && validadeEffects()) {
            Ingredient ingredient = new Ingredient();
            ingredient.setName(etName.getText().toString().trim().toUpperCase());
            ingredient.setPrice(Integer.parseInt(etPrice.getText().toString()));
            ingredient.setFirstEffect(spFirstEffect.getSelectedItem().toString());
            ingredient.setSecondEffect(spSecondEffect.getSelectedItem().toString());
            ingredient.setThirdEffect(spThirdEffect.getSelectedItem().toString());
            ingredient.setFourthEffect(spFourthEffect.getSelectedItem().toString());

            if (validateDuplicateIngredient(ingredient)) {
                Preferences.saveIngredient(ingredient);
                Snackbar.make(btnSave, "Ingredient saved!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                clearFields();
            } else {
                Snackbar.make(btnSave, "Ingredient already exists", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        }
    }

    private void clearFields() {
        etName.setText("");
        etPrice.setText("");
        spFirstEffect.setSelection(0);
        spSecondEffect.setSelection(0);
        spThirdEffect.setSelection(0);
        spFourthEffect.setSelection(0);
    }

    private boolean validateDuplicateIngredient(Ingredient ingredient) {
        ArrayList<Ingredient> ingredientList = Preferences.getIngredients();

        for (Ingredient ingredientItem : ingredientList) {
            if (ingredient.getName().equalsIgnoreCase(ingredientItem.getName())) {
                return false;
            }
        }
        return true;
    }

    private boolean validadeEmptyFields() {
        if (etName.getText().toString().isEmpty()) {
            etName.setError("Required");
            return false;
        }
        if (etPrice.getText().toString().isEmpty()) {
            etPrice.setError("Required");
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
                etName.setError("No effect can double");
                return false;
            }
        }

        if (!secondEffect.equalsIgnoreCase("Unknown")) {
            if (secondEffect.equalsIgnoreCase(thirdEffect) || secondEffect.equalsIgnoreCase(fourthEffect)) {
                etName.setError("No effect can double");
                return false;
            }
        }

        if (!thirdEffect.equalsIgnoreCase("Unknown")) {
            if (thirdEffect.equalsIgnoreCase(fourthEffect)) {
                etName.setError("No effect can double");
                return false;
            }
        }

        etName.setError(null);
        return true;
    }

}