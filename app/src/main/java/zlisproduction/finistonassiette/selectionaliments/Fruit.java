package zlisproduction.finistonassiette.selectionaliments;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
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
public class Fruit extends ListAlimDisplay {

    private HashMap<String, Integer> hashMapFruit= new  HashMap<String, Integer>();
    private ArrayList<Aliment> arrayListAliments;
    private GridView lv;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Changer le titre de la barre d'action
        ActionBar actionbar = getActivity().getActionBar();
        actionbar.setTitle(getResources().getString(R.string.Incontournable));
        // FragmentActivity faActivity  = (FragmentActivity)    super.getActivity();
        // Replace LinearLayout by the type of the root element of the layout you're trying to load
        View lLayout = inflater.inflate(R.layout.listview, container, false);
        // Of course you will want to faActivity and llLayout in the class and not this method to access them in the rest of
        // the class, just initialize them here

        lv = (GridView) lLayout.findViewById(R.id.ListViewAliment);

        /*
        Création de la Hashmap hashMapIncontournable
         */
        hashMapFruit.put(getString(R.string.Abricots), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Amandes), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Ananas), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Banane), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Cassis), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Cerises), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Châtaignes), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Citron), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Citron_vert), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Clémentine), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Coing), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Dattes), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Figues), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Fraises), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Framboises), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Fruit_de_la_passion), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Fruits_confits), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Goyave), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Groseilles), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Kiwi), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Litchies), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Mangue), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Melon), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Mirabelles), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Myrtilles), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Noisettes), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Orange), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Pamplemousse), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Papaye), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Pêche), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Pastèque), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Pistaches), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Poire), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Pomme), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Prunes), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Raisin_blanc), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Raisin_noir), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Rhubarde), R.drawable.ic_beurretransparent);


        arrayListAliments = ListeAliment.alimentsArraylist(hashMapFruit);
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
