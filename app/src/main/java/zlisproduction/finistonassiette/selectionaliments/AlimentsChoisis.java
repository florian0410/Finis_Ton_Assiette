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

import zlisproduction.finistonassiette.R;
import zlisproduction.finistonassiette.adapter.Adapter;

/**
 * Created by Florian.S on 17/06/2015.
 */
public class AlimentsChoisis extends AlimentListDisplayer {
    private GridView lv;
    private Button boutonfin = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Changer le titre de la barre d'action
        ActionBar actionbar = getActivity().getActionBar();
        actionbar.setTitle(getResources().getString(R.string.aliments_selectionnes));
        View lLayout = inflater.inflate(R.layout.listview, container, false);

        lv = (GridView) lLayout.findViewById(R.id.ListViewAliment);
        boutonfin=(Button) lLayout.findViewById(R.id.boutonfinselection);


        //fabrication de la liste à partir d'une hashmap d'aliments
        arrayListAlimentsDisplayer = ListeAliment.alimentsArraylist(CreateListAliment.getAlimentsSelectionnes());
        myAdapter = new Adapter(arrayListAlimentsDisplayer, super.context);
        lv.setAdapter(myAdapter);
        // Listener pour sélection des aliments
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlimentDisplayer alim = arrayListAlimentsDisplayer.get(position);
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
