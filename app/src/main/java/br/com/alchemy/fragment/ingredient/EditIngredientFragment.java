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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.alchemy.R;
import br.com.alchemy.model.Ingredient;
import br.com.alchemy.util.Preferences;

public class EditIngredientFragment extends Fragment {

    private EditText etName;
    private EditText etPrice;
    private Spinner spFirstEffect;
    private Spinner spSecondEffect;
    private Spinner spThirdEffect;
    private Spinner spFourthEffect;
    private TextView tvTitle;
    private Button btnSave;
    private Ingredient ingredient;

    public EditIngredientFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_ingredient, container, false);
        initViews(view);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            ingredient = (Ingredient) bundle.getSerializable("ingredient");
            tvTitle.setText("Editing " + ingredient.getName());
        }
        populateSpinnerEffect(spFirstEffect);
        populateSpinnerEffect(spSecondEffect);
        populateSpinnerEffect(spThirdEffect);
        populateSpinnerEffect(spFourthEffect);
        populateIngredientDetail(ingredient);
        return view;
    }

    private void initViews(View view) {
        tvTitle = (TextView) view.findViewById(R.id.tv_title);
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

    private void populateIngredientDetail(Ingredient ingredient) {
        etName.setText(ingredient.getName());
        etPrice.setText(String.valueOf(ingredient.getPrice()));
        spFirstEffect.setSelection(((ArrayAdapter<String>) spFirstEffect.getAdapter()).getPosition(ingredient.getFirstEffect()));
        spSecondEffect.setSelection(((ArrayAdapter<String>) spSecondEffect.getAdapter()).getPosition(ingredient.getSecondEffect()));
        spThirdEffect.setSelection(((ArrayAdapter<String>) spThirdEffect.getAdapter()).getPosition(ingredient.getThirdEffect()));
        spFourthEffect.setSelection(((ArrayAdapter<String>) spFourthEffect.getAdapter()).getPosition(ingredient.getFourthEffect()));
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
            Ingredient ingredientNew = new Ingredient();
            ingredientNew.setName(etName.getText().toString().trim().toUpperCase());
            ingredientNew.setPrice(Integer.parseInt(etPrice.getText().toString()));
            ingredientNew.setFirstEffect(spFirstEffect.getSelectedItem().toString());
            ingredientNew.setSecondEffect(spSecondEffect.getSelectedItem().toString());
            ingredientNew.setThirdEffect(spThirdEffect.getSelectedItem().toString());
            ingredientNew.setFourthEffect(spFourthEffect.getSelectedItem().toString());

            Preferences.editIngredient(ingredient.getName(), ingredientNew);
            Snackbar.make(btnSave, "Ingredient has been edited!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            getActivity().onBackPressed();
        }
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
