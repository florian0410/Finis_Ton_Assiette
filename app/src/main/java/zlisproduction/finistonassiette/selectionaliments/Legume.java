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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import zlisproduction.finistonassiette.R;
import zlisproduction.finistonassiette.adapter.Adapter;
import zlisproduction.finistonassiette.recette.ConstructeurDefaut;
import zlisproduction.finistonassiette.recette.ConsulterRecette;
import zlisproduction.finistonassiette.recette.Information;
import zlisproduction.finistonassiette.recette.JsonFormat;

/**
 * Created by Florian on 15/05/2015.
 */
public class Legume extends AlimentListDisplayer {


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

        Aliment alim = new Aliment(context);
        //fabrication de l'objet aliment
        arrayListAlimentsDisplayer = ListeAliment.alimentsArraylist(alim.getHashMapAlimentFromCategorie(getString(R.string.Legume)));
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
                //CreateListAliment.getAlimList(context);
                // Retour au menu principal
                // Plus tard ce sera affichage de la liste des résultats
                //Fragment fragment = new MenuPrincipal();
                //ChangeFragment(v, fragment);
                // définition des comportements pour la requête consulter recette
                if (CreateListAliment.getAlimentsSelectionnes().size()!=0)
                {
                    Information frag = new Information();
                    frag.setRequete(new ConsulterRecette());
                    ArrayList<String> tmpstring = CreateListAliment.HashMapToArrayList();
                    String[] tmp = frag.executeRequest(tmpstring);
                    if(tmp.length !=1){


                        frag.setAnalyse_resultat(new JsonFormat(tmp));
                        frag.setInstancie(new ConstructeurDefaut());
                        frag.changementFragment(frag.analyse_result(), getActivity().getFragmentManager());

                    }
                    else{
                        Toast.makeText(context, "Aucune recette pour l'instant!", Toast.LENGTH_SHORT).show();
                    }
                }
                else{

                    Toast.makeText(context, "Vous n'avez pas sélectionnez d'aliments !", Toast.LENGTH_SHORT).show();

                }
            }
        });
        return lLayout;
    }
}
