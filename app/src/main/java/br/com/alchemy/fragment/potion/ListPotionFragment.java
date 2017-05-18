package br.com.alchemy.fragment.potion;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.alchemy.R;
import br.com.alchemy.adapter.PotionListAdapter;
import br.com.alchemy.model.Potion;
import br.com.alchemy.util.Preferences;

public class ListPotionFragment extends Fragment {

    private ListView lvPotions;
    private EditText etSearch;
    private ArrayList<Potion> itens;
    private PotionListAdapter potionListAdapter;

    public ListPotionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_potion, container, false);

        getActivity().setTitle("List potions");
        initViews(view);

        createListView(Preferences.getPotions());
        return view;
    }

    private void initViews(View view) {
        lvPotions = (ListView) view.findViewById(R.id.lv_potions);
//        lvPotions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Potio ingredient = (Ingredient) parent.getItemAtPosition(position);
//                Fragment editIngredientFragment = new EditIngredientFragment();
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("ingredient", ingredient);
//                editIngredientFragment.setArguments(bundle);
//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//
//                transaction.replace(R.id.app_content, editIngredientFragment);
//                transaction.addToBackStack(null);
//
//                transaction.commit();
//            }
//        });
        etSearch = (EditText) view.findViewById(R.id.et_search);
        etSearch.setInputType(InputType.TYPE_CLASS_TEXT);
//        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
//                if (i == EditorInfo.IME_ACTION_DONE) {
//                    ArrayList searchList = Preferences.getIngredientsByParam(etSearch.getText().toString().trim().toUpperCase());
//                    createListView(searchList);
//                }
//
//                return false;
//            }
//        });
    }
    private void createListView(ArrayList<Potion> potionsList) {
        itens = new ArrayList<>();

        for (Potion potion : potionsList) {
            Potion item = new Potion(
                    potion.getDescription(),
                    potion.getFirstIngredient(),
                    potion.getSecondIngredient(),
                    potion.getOptionalIngredient(),
                    potion.isExpensive(),
                    potion.isStrong()
            );
            itens.add(item);
        }
        potionListAdapter = new PotionListAdapter(getActivity(), itens);
        lvPotions.setAdapter(potionListAdapter);
    }

}
