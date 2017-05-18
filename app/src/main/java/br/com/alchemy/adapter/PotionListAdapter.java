package br.com.alchemy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.alchemy.R;
import br.com.alchemy.model.Potion;

public class PotionListAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private ArrayList<Potion> itens;

    public PotionListAdapter(Context context, ArrayList<Potion> itens) {
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
        Potion item = itens.get(position);
        view = mInflater.inflate(R.layout.item_potion, null);

        ((TextView) view.findViewById(R.id.tv_potion_description)).setText(item.getDescription());
        ((TextView) view.findViewById(R.id.tv_potion_first_effect)).setText(item.getFirstIngredient());
        ((TextView) view.findViewById(R.id.tv_potion_second_effect)).setText(item.getSecondIngredient());

        if (item.getOptionalIngredient().isEmpty()){
            view.findViewById(R.id.tv_potion_optional_effect).setVisibility(View.GONE);
        } else {
            ((TextView) view.findViewById(R.id.tv_potion_optional_effect)).setText(item.getOptionalIngredient());
        }

        ImageView ivPotionExpensive = (ImageView) view.findViewById(R.id.iv_potion_expensive);
        if (item.isExpensive()) {
            ivPotionExpensive.setImageResource(R.drawable.ic_coins);
        } else {
            ivPotionExpensive.setImageResource(R.drawable.ic_coins_disable);
        }

        ImageView ivPotionStrong = (ImageView) view.findViewById(R.id.iv_potion_strong);
        if (item.isStrong()) {
            ivPotionStrong.setImageResource(R.drawable.ic_nuclear);
        } else {
            ivPotionStrong.setImageResource(R.drawable.ic_nuclear_disable);
        }

        return view;
    }
}
