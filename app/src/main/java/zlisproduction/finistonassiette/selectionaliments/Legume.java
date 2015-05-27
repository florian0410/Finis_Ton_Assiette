package zlisproduction.finistonassiette.selectionaliments;

import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
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
public class Legume extends AlimentListDisplayer {

    private HashMap<String, Integer> hashMapLegumes= new HashMap<String, Integer>();
    private GridView lv;
    private Button boutonfin = null;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Changer le titre de la barre d'action
        ActionBar actionbar = getActivity().getActionBar();
        actionbar.setTitle(getResources().getString(R.string.Legume));
        // FragmentActivity faActivity  = (FragmentActivity)    super.getActivity();
        // Replace LinearLayout by the type of the root element of the layout you're trying to load
        View lLayout = inflater.inflate(R.layout.listview, container, false);
        // Of course you will want to faActivity and llLayout in the class and not this method to access them in the rest of
        // the class, just initialize them here
        lv = (GridView) lLayout.findViewById(R.id.ListViewAliment);
        boutonfin=(Button) lLayout.findViewById(R.id.boutonfinselection);

        /*
        Création de la Hashmap
         */
        hashMapLegumes.put(getString(R.string.Artichaut), R.drawable.ic_1courgettetransparente);
        hashMapLegumes.put(getString(R.string.Aubergine),R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Avocat), R.drawable.ic_1courgettetransparente);
        hashMapLegumes.put(getString(R.string.Betterave),R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Brocoli), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Carotte), R.drawable.ic_1courgettetransparente);
        hashMapLegumes.put(getString(R.string.chou_blanc_ou_vert), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.chou_fleur), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Choux_de_Bruxelles), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Coeur_de_palmier), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Concombre), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Courgette), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Épinards), R.drawable.ic_1courgettetransparente);
        hashMapLegumes.put(getString(R.string.Fenouil), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Flageolets), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Germes_de_soja), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Haricots_verts), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Lentilles), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Maïs), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Navet), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Olives_noires), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Olives_vertes), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Patate_douce), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Petits_pois), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Poireau), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Pois_cassés), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Pois_chiches), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Pois_gourmands), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Poivron), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Potimarron), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Potiron), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Radis), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Salade_verte), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Tomate_verte), R.drawable.ic_beurretransparent);

        arrayListAliments = ListeAliment.alimentsArraylist(hashMapLegumes);
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

        //Listener permettant l'envoi des aliments choisis à l'appui du bouton
        boutonfin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateListAliment.getAlimList(context);
                // Retour au menu principal
                // Plus tard ce sera affichage de la liste des résultats
                Fragment fragment = new MenuPrincipal();
                ChangeFragment(v, fragment);
            }
        });
        return lLayout;
    }
}
