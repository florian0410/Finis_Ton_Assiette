package zlisproduction.finistonassiette.recette;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;

import zlisproduction.finistonassiette.R;

/**
 * Created by Thibaut on 24/05/2015.
 *
 */
public class ConstructeurDefaut extends Fragment implements Instanciation  {

   private String[] recettes= null;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View Layout= inflater.inflate(R.layout.constructeurdefautlayout, container, false);

       /* SimpleAdapter mSchedule = new SimpleAdapter(this.getBaseContext(), listItem, R.layout.constructeurdefautlayout,
                new String[] {"nom_recette_creee", "type_plat", "niveau_difficulte","ingredient","temps_cuisson","temps_preparation","preparation_recette","auteur_recette"}, new int[] {R.id.nomrecette, R.id.typeplat, R.id.niveaudifficulte,R.id.ingredient,R.id.tempspreparation,R.id.preparation,R.id.donneessupplementaire});

        */
        // Inflate the layout for this fragment
        return Layout;
    }


    @Override
    public void instancie(String[] pArray) {

    }
}
