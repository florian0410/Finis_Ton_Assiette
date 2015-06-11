package zlisproduction.finistonassiette.selectionaliments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import zlisproduction.finistonassiette.R;
import zlisproduction.finistonassiette.adapter.Adapter;

/**
 * Created by Florian.S on 27/05/2015.
 * Classe permettant de rassembler les différentes méthodes utilisées dans chaque liste d'aliment
 */
public class AlimentListDisplayer extends Fragment {

    protected Context context= null;
    protected Adapter myAdapter = null;
    protected ArrayList<AlimentDisplayer> arrayListAlimentsDisplayer;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = activity.getApplicationContext();
    }


    // Retrouve la position d'un aliment dans la lsite et change son fond en l'ajoutant à la liste des aliments sélectionnés par l'utilisateur
    public void CheckItem(AlimentDisplayer pAlim, Adapter pAdapter){
        boolean test;
        //On met l'aliment dans la liste des aliments sélectionnés
        test = CreateListAliment.addAlimentSelectionne(pAlim.getName());
        // Si déjà choisi avant on le notifie
        if(test) {
            Toast.makeText(context,context.getString(R.string.aliment_déjà_choisi), Toast.LENGTH_SHORT).show();
        }
        pAlim.setIsClicked(true);
        // On demande l'actualisation de l'affichage à l'adapter qui va vérifier chaque valeur de IsClicked et donc changer la couleur de fond de l'image (dans Adapter)
        pAdapter.notifyDataSetChanged();
    }

    public void unCheckItem(AlimentDisplayer pAlim, Adapter pAdapter){
        // On enléve l'aliment déselectionné
        CreateListAliment.deleteAliment(pAlim.getName());
        pAlim.setIsClicked(false);
        // On demande l'actualisation de l'affichage à l'adapter qui va vérifier chaque valeur de IsClicked et donc changer la couleur de fond de l'image (dans Adapter)
        pAdapter.notifyDataSetChanged();
    }

    public void ChangeFragment(View pView, Fragment pFragment){
        if (pFragment != null) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_container, pFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else {
            // error in creating fragment
            Log.e("ChangeFragment()", "Error in creating fragment");
        }
    }
}
