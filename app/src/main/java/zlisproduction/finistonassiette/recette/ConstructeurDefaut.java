package zlisproduction.finistonassiette.recette;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
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
    Context context=null;
    ListView lv =null;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = activity.getApplicationContext();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        //Layout du fragment
        View Layout= inflater.inflate(R.layout.constructeurdefautlayout, container, false);
        lv =   (ListView) Layout.findViewById(R.id.listeViewConstructeurDefaut);
        // on récupère les paramètres envoyés
        Bundle bundle = this.getArguments();
        data_a_afficher = (ArrayList<HashMap<String, String>>) bundle.getSerializable("ingredients");



      SimpleAdapter mSchedule = new SimpleAdapter(this.context, data_a_afficher, R.layout.constructeurdefautitemlayout,
              new String[] {"nom_recette_creee",  "niveau_difficulte","temps_cuisson","preparation_recette","ingredient","temps_preparation","type_plat","auteur_recette"}, new int[] {R.id.nomrecette, R.id.typeplat, R.id.niveaudifficulte,R.id.ingredient,R.id.tempspreparation,R.id.tempspreparation,R.id.preparation,R.id.donneessupplementaire});


        lv.setAdapter(mSchedule);

        // Inflate the layout for this fragment
        return Layout;
    }



}
