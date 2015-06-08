package zlisproduction.finistonassiette.recette;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import zlisproduction.finistonassiette.R;

/**
 * Created by Thibaut on 24/05/2015.
 *
 */
public class ConstructeurDefaut extends Instanciation  {

   private String[] recettes= null;
    private ArrayList<HashMap<String, String>> data_a_afficher;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        //Layout du fragment
        View Layout= inflater.inflate(R.layout.constructeurdefautlayout, container, false);
        // on récupère les paramètres envoyés
        Bundle bundle = this.getArguments();
        data_a_afficher = (ArrayList<HashMap<String, String>>) bundle.getSerializable("ingredients");



       SimpleAdapter mSchedule = new SimpleAdapter(this.getActivity(), data_a_afficher, R.layout.constructeurdefautlayout,
                new String[] {"nom_recette_creee", "type_plat", "niveau_difficulte","ingredient","temps_cuisson","temps_preparation","preparation_recette","auteur_recette"}, new int[] {R.id.nomrecette, R.id.typeplat, R.id.niveaudifficulte,R.id.ingredient,R.id.tempspreparation,R.id.preparation,R.id.donneessupplementaire});


        // Inflate the layout for this fragment
        return Layout;
    }



}
