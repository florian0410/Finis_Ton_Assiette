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
 * Created by Thibaut on 16/05/2015.
 */
public class Pates extends ListAlimDisplay {

    private final HashMap<String, Integer> hashMapPates = new HashMap<String, Integer>();
    private ArrayList<Aliment> arrayListAliments;
    private GridView lv;
    private Context context=null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Changer le titre de la barre d'action
        ActionBar actionbar = getActivity().getActionBar();
        actionbar.setTitle(getResources().getString(R.string.Pates));
        View lLayout = inflater.inflate(R.layout.listview, container, false);
        lv = (GridView) lLayout.findViewById(R.id.ListViewAliment);

        // Remplissage de la HashMap associant le nom de l'aliment (clé) et son image (objet renvoyé par clé)
        hashMapPates.put(getString(R.string.Coquillettes), R.drawable.ic_beurretransparent);
        hashMapPates.put(getString(R.string.Spaghetti), R.drawable.ic_beurretransparent);
        hashMapPates.put(getString(R.string.Farfalle), R.drawable.ic_beurretransparent);
        hashMapPates.put(getString(R.string.Penne_Rigate), R.drawable.ic_beurretransparent);
        hashMapPates.put(getString(R.string.Linguine), R.drawable.ic_beurretransparent);
        hashMapPates.put(getString(R.string.Tagliatelle), R.drawable.ic_beurretransparent);
        hashMapPates.put(getString(R.string.Macaroni), R.drawable.ic_beurretransparent);
        hashMapPates.put(getString(R.string.Nouilles), R.drawable.ic_beurretransparent);
        hashMapPates.put(getString(R.string.Fusilli), R.drawable.ic_beurretransparent);
        hashMapPates.put(getString(R.string.Capellini), R.drawable.ic_beurretransparent);
        hashMapPates.put(getString(R.string.Torti), R.drawable.ic_beurretransparent);
        hashMapPates.put(getString(R.string.Vermicelli), R.drawable.ic_beurretransparent);
        hashMapPates.put(getString(R.string.Lasagnes), R.drawable.ic_beurretransparent);

        arrayListAliments = ListeAliment.alimentsArraylist(hashMapPates);
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
