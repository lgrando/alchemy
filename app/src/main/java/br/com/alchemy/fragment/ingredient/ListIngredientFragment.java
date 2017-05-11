package br.com.alchemy.fragment.ingredient;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.alchemy.R;
import br.com.alchemy.adapter.IngredientListAdapter;
import br.com.alchemy.adapter.IngredientListItem;
import br.com.alchemy.model.IngredientObject;
import br.com.alchemy.util.Preferences;
import br.com.alchemy.util.Util;

public class ListIngredientFragment extends Fragment {

    private ListView lvIngredients;
    private EditText etSearch;
    private ArrayList<IngredientListItem> itens;
    private IngredientListAdapter ingredientListAdapter;

    public ListIngredientFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_ingredient, container, false);

        initViews(view);

        createListView(Util.getIngredients());

        return view;
    }

    private void initViews(View view) {
        lvIngredients = (ListView) view.findViewById(R.id.lv_ingredients);
        lvIngredients.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                IngredientListItem ingredient = (IngredientListItem) parent.getItemAtPosition(position);
                Fragment editIngredientFragment = new EditIngredientFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("ingredient", ingredient);
                editIngredientFragment.setArguments(bundle);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                transaction.replace(R.id.app_content, editIngredientFragment);
                transaction.addToBackStack(null);

                transaction.commit();
            }
        });
        etSearch = (EditText) view.findViewById(R.id.et_search);
        etSearch.setInputType(InputType.TYPE_CLASS_TEXT);
        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_DONE) {
                    ArrayList searchList = Preferences.getIngredientsByParam(etSearch.getText().toString().trim().toUpperCase());
                    createListView(searchList);
                }

                return false;
            }
        });
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
        }
        ingredientListAdapter = new IngredientListAdapter(getActivity(), itens);
        lvIngredients.setAdapter(ingredientListAdapter);
    }

}
