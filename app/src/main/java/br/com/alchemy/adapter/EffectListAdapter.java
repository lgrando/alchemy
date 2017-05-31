package br.com.alchemy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.alchemy.R;
import br.com.alchemy.model.Effect;
import br.com.alchemy.model.Ingredient;

public class EffectListAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private ArrayList<Effect> itens;

    public EffectListAdapter(Context context, ArrayList<Effect> itens) {
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
        Effect item = itens.get(position);
        view = mInflater.inflate(R.layout.item_effect, null);

        ((TextView) view.findViewById(R.id.tv_effect_name)).setText(item.getName());
        ((TextView) view.findViewById(R.id.tv_effect_value)).setText(String.valueOf(item.getValue()));

        return view;
    }
}
