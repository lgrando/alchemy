package br.com.alchemy.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.alchemy.R;
import br.com.alchemy.adapter.IngredientListAdapter;
import br.com.alchemy.adapter.IngredientListItem;
import br.com.alchemy.util.Constant;
import br.com.alchemy.util.MultipleChoiceListDialogListener;

public class MakePotionFragment extends Fragment implements MultipleChoiceListDialogListener {

    private Button btnChoose;
    private ListView lvResult;
    private ArrayList<IngredientListItem> itens;
    private ArrayList<Integer> list;
    private IngredientListAdapter ingredientListAdapter;

    public MakePotionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_make_potion, container, false);

        initViews(view);

//        createListView(Preferences.getIngredients(getActivity()));
        return view;
    }

//    private void createListView(ArrayList<IngredientObject> ingredients) {
//        itens = new ArrayList<>();
//
//        for (IngredientObject ingredient : ingredients) {
//            IngredientListItem item = new IngredientListItem(
//                    ingredient.getName(),
//                    ingredient.getFirstEffect(),
//                    ingredient.getSecondEffect(),
//                    ingredient.getThirdEffect(),
//                    ingredient.getFourthEffect(),
//                    ingredient.getPrice()
//            );
//        }
//        ingredientListAdapter = new IngredientListAdapter(getActivity(), itens);
//        lvResult.setAdapter(ingredientListAdapter);
//    }

    private void initViews(View view) {
        btnChoose = (Button) view.findViewById(R.id.btn_choose);
        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMultipleChoiceDialog();
            }
        });
        lvResult = (ListView) view.findViewById(R.id.lv_result);
    }

    private void openMultipleChoiceDialog() {
        list = new ArrayList<>();
        boolean[] isSelectedArray = {true,false,true,true,false,false,false};
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Selecione os efeitos")
                .setMultiChoiceItems(Constant.EFFECTS, isSelectedArray,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                if(isChecked){
                                    list.add(which);
                                } else if(list.contains(which)){
                                    list.remove(Integer.valueOf(which));
                                }
                            }
                        })
                .setPositiveButton("Buscar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        onOkay(list);
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onCancel(dialog);
                    }
                });

        builder.show();

    }

    @Override
    public void onOkay(ArrayList<Integer> arrayList) {
        StringBuilder stringBuilder = new StringBuilder();
        if(arrayList.size() != 0){
            for(int i = 0 ; i < arrayList.size() ; i++){
                String effect = Constant.EFFECTS[arrayList.get(i)];
                stringBuilder = stringBuilder.append(" "+effect);
            }
            Toast.makeText(getActivity(), "Selecionado: "+stringBuilder.toString(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        dialog.dismiss();
    }
}
