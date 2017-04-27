package br.com.alchemy.util;

import android.content.DialogInterface;

import java.util.ArrayList;

/**
 * Created by Lucas.Grando on 27/04/2017.
 */

public interface MultipleChoiceListDialogListener {

    void onOkay(ArrayList<Integer> arrayList);
    void onCancel(DialogInterface dialog);
}
