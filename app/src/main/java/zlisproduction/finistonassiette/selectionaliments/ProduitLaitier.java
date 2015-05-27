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
public class ProduitLaitier extends ListAlimDisplay {
    private HashMap<String, Integer> hashMapProduitLaitier = new HashMap<String, Integer>();
    private ArrayList<Aliment> arrayListAliments;
    private GridView lv;



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ActionBar actionbar = getActivity().getActionBar();
        actionbar.setTitle(getResources().getString(R.string.Produits_Laitier));
        // FragmentActivity faActivity  = (FragmentActivity)    super.getActivity();
        // Replace LinearLayout by the type of the root element of the layout you're trying to load
        View lLayout = inflater.inflate(R.layout.listview, container, false);
        // Of course you will want to faActivity and llLayout in the class and not this method to access them in the rest of
        // the class, just initialize them here
        lv = (GridView) lLayout.findViewById(R.id.ListViewAliment);
        /*
        Création de la Hashmap hashMapIncontournable
         */
        hashMapProduitLaitier.put(getString(R.string.Brie), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(getString(R.string.Camembert), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(getString(R.string.Cantal), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(getString(R.string.Chévre_Brebis), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(getString(R.string.Comté), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(getString(R.string.Feta), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(getString(R.string.Fromage_blanc), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(getString(R.string.Lait_de_coco), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(getString(R.string.Lait_de_soja), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(getString(R.string.Mascarpone), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(getString(R.string.Mont_d_Or), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(getString(R.string.Mozarella), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(getString(R.string.Parmesan), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(getString(R.string.Petits_suisses), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(getString(R.string.Raclette), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(getString(R.string.Roquefort), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(getString(R.string.Saint_Marcelin), R.drawable.ic_beurretransparent);

        arrayListAliments = ListeAliment.alimentsArraylist(hashMapProduitLaitier);
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
