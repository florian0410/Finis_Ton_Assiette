package zlisproduction.finistonassiette.selectionaliments;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.HashMap;

import zlisproduction.finistonassiette.R;
import zlisproduction.finistonassiette.adapter.Adapter;

/**
 * Created by Florian on 15/05/2015.
 */
public class Cereale extends ListAlimDisplay {

    private  HashMap <String, Integer> hashMapCereales= new HashMap <String, Integer>();
    private ArrayList<Aliment> arrayListAliments;
    private GridView lv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Changer le titre de la barre d'action
        ActionBar actionbar = getActivity().getActionBar();
        actionbar.setTitle(getResources().getString(R.string.Incontournable));

        View lLayout = inflater.inflate(R.layout.listview, container, false);
        lv = (GridView) lLayout.findViewById(R.id.ListViewAliment);

        hashMapCereales.put(getString(R.string.Blé), R.drawable.ic_beurretransparent);
        hashMapCereales.put(getString(R.string.Boulghour), R.drawable.ic_beurretransparent);
        hashMapCereales.put(getString(R.string.Farine_de_froment), R.drawable.ic_beurretransparent);
        hashMapCereales.put(getString(R.string.Lasagnes), R.drawable.ic_beurretransparent);
        hashMapCereales.put(getString(R.string.Müesli), R.drawable.ic_beurretransparent);
        hashMapCereales.put(getString(R.string.Pâtes_de_riz), R.drawable.ic_beurretransparent);
        hashMapCereales.put(getString(R.string.Quinoa), R.drawable.ic_beurretransparent);
        hashMapCereales.put(getString(R.string.Riz_complet), R.drawable.ic_beurretransparent);
        hashMapCereales.put(getString(R.string.Sarrasin), R.drawable.ic_beurretransparent);


        //fabrication de l'objet aliment
        arrayListAliments = ListeAliment.alimentsArraylist(hashMapCereales);
        //mise en page
        myAdapter = new Adapter(arrayListAliments, super.context);
        lv.setAdapter(myAdapter);
        // Listener pour sélection des aliments
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Aliment alim = arrayListAliments.get(position);
                if (alim.isClicked() == false) {
                    CheckItem(alim, myAdapter);
                } else {
                    unCheckItem(alim, myAdapter);
                }
            }
        });

        return lLayout;
    }
}
