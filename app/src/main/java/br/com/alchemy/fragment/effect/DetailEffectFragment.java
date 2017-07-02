package br.com.alchemy.fragment.effect;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.alchemy.R;
import br.com.alchemy.model.Effect;
import br.com.alchemy.model.Ingredient;
import br.com.alchemy.util.Preferences;

public class DetailEffectFragment extends Fragment {

    private GridLayout glIngredients;
    private TextView tvEffectName;
    private Effect effect;

    public DetailEffectFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_effect, container, false);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            effect = (Effect) bundle.getSerializable("effect");
        }

        initViews(view);

        TextView text;
        tvEffectName.setText(effect.getName());
        ArrayList<Ingredient> searchList = Preferences.getIngredientsByParam(effect.getName().toUpperCase());
        glIngredients.setAlignmentMode(GridLayout.ALIGN_BOUNDS);
        glIngredients.setColumnCount(2);

        for (Ingredient ingredient : searchList){
            text = new TextView(getActivity());
            text.setText(ingredient.getName());
            glIngredients.addView(text);
        }

        return view;
    }

    private void initViews(View view) {
        glIngredients = (GridLayout) view.findViewById(R.id.gl_ingredients);
        tvEffectName = (TextView) view.findViewById(R.id.tv_effect_name);
    }

}
