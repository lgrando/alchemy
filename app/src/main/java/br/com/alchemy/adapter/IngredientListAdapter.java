package br.com.alchemy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.alchemy.R;

public class IngredientListAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private ArrayList<IngredientListItem> itens;

    public IngredientListAdapter(Context context, ArrayList<IngredientListItem> itens) {
        this.itens = itens;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itens.size();
    }

    @Override
    public Object getItem(int position) {
        return itens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
}

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        IngredientListItem item = itens.get(position);
        view = mInflater.inflate(R.layout.item_ingredient, null);

        ((TextView) view.findViewById(R.id.tv_item_name)).setText(item.getName()+" ($"+item.getPrice()+")");
        ((TextView) view.findViewById(R.id.tv_item_first_effect)).setText(item.getFirstEffect());
        ((TextView) view.findViewById(R.id.tv_item_second_effect)).setText(item.getSecondEffect());
        ((TextView) view.findViewById(R.id.tv_item_third_effect)).setText(item.getThirdEffect());
        ((TextView) view.findViewById(R.id.tv_item_fourth_effect)).setText(item.getFourthEffect());

        return view;
    }
}
