package br.com.alchemy.fragment.potion;

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
import java.util.Collections;
import java.util.List;

import br.com.alchemy.R;
import br.com.alchemy.model.Ingredient;
import br.com.alchemy.model.Potion;
import br.com.alchemy.util.Preferences;
import br.com.alchemy.util.Util;

public class AddPotionFragment extends Fragment {

    private EditText etDescription;
    private Spinner spFirstIngredient;
    private Spinner spSecondIngredient;
    private Spinner spOptionalIngredient;
    private Button btnSave;

    public AddPotionFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_potion, container, false);

        initViews(view);
        populateSpinner(spFirstIngredient, true);
        populateSpinner(spSecondIngredient, true);
        populateSpinner(spOptionalIngredient, false);

        return view;
    }

    private void populateSpinner(Spinner spinner, boolean required) {
        List<String> ingredientList = new ArrayList<>();
        populateIngredientList(ingredientList, required);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, ingredientList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

    }

    private void populateIngredientList(List<String> list, boolean required) {
        for (Ingredient ingredient : Util.getIngredients()) {
            list.add(ingredient.getName());
        }
        Collections.sort(list);
        if (required) {
            list.add(0, "Select an ingredient");
        } else {
            list.add(0, "Optional ingredient");
        }
    }

    private void initViews(View view) {
        etDescription = (EditText) view.findViewById(R.id.et_description);
        spFirstIngredient = (Spinner) view.findViewById(R.id.sp_first_ingredient);
        spSecondIngredient = (Spinner) view.findViewById(R.id.sp_second_ingredient);
        spOptionalIngredient = (Spinner) view.findViewById(R.id.sp_optional_ingredient);
        btnSave = (Button) view.findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewPotion();
            }
        });
    }

    private void saveNewPotion() {
        if (validadeEmptyFields() && validadeIngredients()) {

            Potion potion = new Potion();
            potion.setDescription(Util.initcaps(etDescription.getText().toString().trim()));
            potion.setFirstIngredient(spFirstIngredient.getSelectedItem().toString());
            potion.setSecondIngredient(spSecondIngredient.getSelectedItem().toString());
            potion.setOptionalIngredient(spOptionalIngredient.getSelectedItem().toString());

            if (validateDuplicatePotion(potion)) {
                Preferences.savePotion(potion);
                Snackbar.make(btnSave, "Ingredient saved!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                clearFields();
            } else {
                Snackbar.make(btnSave, "Potion already exists", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        }
    }

    private boolean validateDuplicatePotion(Potion potion) {
        ArrayList<Potion> potionList = Preferences.getPotions();

        for (Potion potionItem : potionList) {
            if (potion.getDescription().equalsIgnoreCase(potionItem.getDescription())) {
                return false;
            }
        }
        return true;
    }

    private void clearFields() {
        etDescription.setText("");
        spFirstIngredient.setSelection(0);
        spSecondIngredient.setSelection(0);
        spOptionalIngredient.setSelection(0);
    }

    private boolean validadeEmptyFields() {
        if (etDescription.getText().toString().isEmpty()) {
            etDescription.setError("Required");
            return false;
        }
        if (spFirstIngredient.getSelectedItemId() == 0) {
            etDescription.setError("First ingredient required");
            return false;
        }

        if (spSecondIngredient.getSelectedItemId() == 0) {
            etDescription.setError("Second ingredient required");
            return false;
        }
        etDescription.setError(null);
        return true;
    }

    private boolean validadeIngredients() {
        String firstIngredient = spFirstIngredient.getSelectedItem().toString();
        String secondIngredient = spSecondIngredient.getSelectedItem().toString();
        String optionalIngredient = spOptionalIngredient.getSelectedItem().toString();

        if (!firstIngredient.equalsIgnoreCase("Select an ingredient")) {
            if (firstIngredient.equalsIgnoreCase(secondIngredient) || firstIngredient.equalsIgnoreCase(optionalIngredient)) {
                etDescription.setError("No ingredient can double");
                return false;
            }
        }

        if (!secondIngredient.equalsIgnoreCase("Select an ingredient")) {
            if (secondIngredient.equalsIgnoreCase(optionalIngredient)) {
                etDescription.setError("No effect can double");
                return false;
            }
        }

        etDescription.setError(null);
        return true;
    }

}
