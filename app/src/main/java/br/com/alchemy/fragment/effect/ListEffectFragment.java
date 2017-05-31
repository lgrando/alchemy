package br.com.alchemy.fragment.effect;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.alchemy.R;

public class ListEffectFragment extends Fragment {

    public ListEffectFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_effect, container, false);

        getActivity().setTitle("List effects");

        initViews(view);

        return view;
    }

    private void initViews(View view) {
    }

}
