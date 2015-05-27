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
public class Viande extends AlimentListDisplayer {

    private HashMap<String, Integer> hashMapViande = new HashMap<String, Integer>();
    private GridView lv;
    private Button boutonfin=null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Changer le titre de la barre d'action
        ActionBar actionbar = getActivity().getActionBar();
        actionbar.setTitle(getResources().getString(R.string.Viande));
        View lLayout = inflater.inflate(R.layout.listview, container, false);
        lv = (GridView) lLayout.findViewById(R.id.ListViewAliment);
        boutonfin=(Button) lLayout.findViewById(R.id.boutonfinselection);

        hashMapViande.put(getString(R.string.Agneau), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Boeuf), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Boudin_blanc), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Boudin_noir), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Caille), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Dinde), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Escargots), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Foie_gras), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Jambon_blanc), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Jambon_cru), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Jambon_fumé), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Lapin), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Lard_Lardons), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Merguez), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Mouton), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Oeufs_à_la_caille), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Os_à_moëlle), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Porc), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Poulet), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Quenelles), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Saucisse), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Saucisson), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Veau), R.drawable.ic_beurretransparent);

        arrayListAliments = ListeAliment.alimentsArraylist(hashMapViande);
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
