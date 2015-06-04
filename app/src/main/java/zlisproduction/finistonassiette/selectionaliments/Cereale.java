package zlisproduction.finistonassiette.selectionaliments;

import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import java.util.HashMap;

import zlisproduction.finistonassiette.R;
import zlisproduction.finistonassiette.adapter.Adapter;

/**
 * Created by Florian on 15/05/2015.
 */
public class Cereale extends AlimentListDisplayer {

    private  HashMap <String, Integer> hashMapCereales= new HashMap <String, Integer>();
    private GridView lv;
    private Button boutonfin = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Changer le titre de la barre d'action
        ActionBar actionbar = getActivity().getActionBar();
        actionbar.setTitle(getResources().getString(R.string.Incontournable));

        View lLayout = inflater.inflate(R.layout.listview, container, false);
        lv = (GridView) lLayout.findViewById(R.id.ListViewAliment);
        boutonfin=(Button) lLayout.findViewById(R.id.boutonfinselection);

        hashMapCereales.put(getString(R.string.Blé), R.drawable.ic_beurretransparent);
        hashMapCereales.put(getString(R.string.Boulghour), R.drawable.ic_boulgourtransparentlast);
        hashMapCereales.put(getString(R.string.Farine_de_froment), R.drawable.ic_farine_fromenttransparent);
        hashMapCereales.put(getString(R.string.Lasagnes), R.drawable.ic_beurretransparent);
        hashMapCereales.put(getString(R.string.Müesli), R.drawable.ic_beurretransparent);
        hashMapCereales.put(getString(R.string.Pâtes_de_riz), R.drawable.ic_beurretransparent);
        hashMapCereales.put(getString(R.string.Quinoa), R.drawable.ic_beurretransparent);
        hashMapCereales.put(getString(R.string.Riz_complet), R.drawable.ic_rizcomplettransparent);
        hashMapCereales.put(getString(R.string.Sarrasin), R.drawable.ic_beurretransparent);


        //fabrication de l'objet aliment
        arrayListAliments = ListeAliment.alimentsArraylist(hashMapCereales);
        //mise en page
        myAdapter = new Adapter(arrayListAliments,context);
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

        //Listener permettant l'envoi des aliments choisis à l'appui du bouton
        boutonfin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateListAliment.getAlimList(context);
                // Retour au menu principal
                // Plus tard ce sera affichage de la liste des résultats
                Fragment fragment = new MenuPrincipal();
                ChangeFragment(v,fragment);
            }
        });
        return lLayout;
    }
}
