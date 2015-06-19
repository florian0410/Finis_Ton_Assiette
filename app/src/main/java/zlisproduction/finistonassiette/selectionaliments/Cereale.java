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
public class Cereale extends AlimentListDisplayer {

    // private  HashMap <String, Integer> hashMapCereales= new HashMap <String, Integer>();
    private GridView lv;
    private Button boutonfin = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Changer le titre de la barre d'action
        ActionBar actionbar = getActivity().getActionBar();
        actionbar.setTitle(getResources().getString(R.string.Céréales));

        View lLayout = inflater.inflate(R.layout.listview, container, false);
        lv = (GridView) lLayout.findViewById(R.id.ListViewAliment);
        boutonfin=(Button) lLayout.findViewById(R.id.boutonfinselection);


        Aliment alim = new Aliment(context);
        //fabrication de l'objet aliment
        arrayListAlimentsDisplayer = ListeAliment.alimentsArraylist(alim.getHashMapAlimentFromCategorie(getString(R.string.Céréales)));
        //mise en page
        myAdapter = new Adapter(arrayListAlimentsDisplayer,context);
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

                // définition des comportements pour la requête consulter recette
                if (CreateListAliment.getAlimentSelectionnes().size()!=0)
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
