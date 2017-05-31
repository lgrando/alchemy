package br.com.alchemy.fragment.effect;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.alchemy.R;
import br.com.alchemy.adapter.EffectListAdapter;
import br.com.alchemy.adapter.IngredientListAdapter;
import br.com.alchemy.model.Effect;
import br.com.alchemy.model.Ingredient;
import br.com.alchemy.util.Util;

public class ListEffectFragment extends Fragment {

    private ListView lvEffects;
    private ArrayList<Effect> itens;
    private EffectListAdapter effectListAdapter;

    public ListEffectFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_effect, container, false);

        getActivity().setTitle("List effects");

        initViews(view);

        createListView(Util.getEffects());

        return view;
    }

    private void initViews(View view) {
        lvEffects = (ListView) view.findViewById(R.id.lv_effects);
        lvEffects.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Effect effect = (Effect) parent.getItemAtPosition(position);
                Fragment detailEffectFragment = new DetailEffectFragment();

                Bundle bundle = new Bundle();
                bundle.putSerializable("effect", effect);
                detailEffectFragment.setArguments(bundle);

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.app_content, detailEffectFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }

    private void createListView(ArrayList<Effect> effects) {
        itens = new ArrayList<>();

        for (Effect effect : effects) {
            Effect item = new Effect(
                    effect.getName(),
                    effect.getValue()
            );
            itens.add(item);
        }
        effectListAdapter = new EffectListAdapter(getActivity(), itens);
        lvEffects.setAdapter(effectListAdapter);
    }

}
