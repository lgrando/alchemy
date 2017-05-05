package br.com.alchemy.fragment;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

import br.com.alchemy.R;
import br.com.alchemy.model.IngredientObject;
import br.com.alchemy.util.Preferences;

public class AddEffectFragment extends Fragment {

    private EditText etName;
    private Button btnSave;

    public AddEffectFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_effect, container, false);

        initViews(view);

        return view;
    }

    private void initViews(View view) {
        etName = (EditText) view.findViewById(R.id.et_name);
        btnSave = (Button) view.findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewEffect();
            }
        });

    }

    private void saveNewEffect() {
        String effect = etName.getText().toString().trim().toUpperCase();
        if (effect.isEmpty()){
            etName.setError("Campo obrigatório");
        } else {
            etName.setError(null);
            if(validateDuplicateEffect(effect)){
                Preferences.saveEffect(effect);
                Snackbar.make(btnSave, "Efeito salvo!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            } else {
                Snackbar.make(btnSave, "Efeito já existe", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        }
    }

    private boolean validateDuplicateEffect(String effect) {
        ArrayList<String> effectList = Preferences.getEffects();

        for (String ef : effectList) {
            if (effect.equalsIgnoreCase(ef)) {
                return false;
            }
        }
        return true;
    }

}
