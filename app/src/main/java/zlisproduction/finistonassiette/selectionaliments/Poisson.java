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
public class Poisson extends AlimentListDisplayer {

    private final  HashMap<String, Integer> HashPoisson = new HashMap<String, Integer>();
    private GridView lv;
    private Button boutonfin=null;


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
        boutonfin=(Button) lLayout.findViewById(R.id.boutonfinselection);

        /*
        Création de la Hashmap
         */
        HashPoisson.put(getString(R.string.Cabillaud), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Calamars), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Colin), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Crevettes), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Daurade), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Flétan), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Gambas), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Haddock), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Hareng), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Lieu), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Maquerau), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Merlu), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Moules), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Oeufs_de_lump), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Saint_Jacques), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Sardines), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Saumon), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Saumon_fumé), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Sole), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Surimi), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Thon_en_boite), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Truite), R.drawable.ic_beurretransparent);

        arrayListAliments = ListeAliment.alimentsArraylist(HashPoisson);
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
