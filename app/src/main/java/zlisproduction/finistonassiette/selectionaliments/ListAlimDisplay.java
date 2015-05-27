package zlisproduction.finistonassiette.selectionaliments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;

import zlisproduction.finistonassiette.adapter.Adapter;

/**
 * Created by Florian.S on 27/05/2015.
 * Classe permettant de rassembler les différentes méthodes utilisées dans chaque liste d'aliment
 */
public class ListAlimDisplay extends Fragment {

    protected Context context= null;
    protected Adapter myAdapter = null;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = activity.getApplicationContext();
    }

    public void CheckItem(Aliment pAlim, Adapter pAdapter){
        //Si l'aliment n'est pas coché on le met dans la liste des résultats et on le met coché
        Result.setAlimentsSelectionnes(pAlim.getName());
        pAlim.setIsClicked(true);
        // On demande l'actualisation de l'affichage à l'adapter qui va vérifier chaque valeur de IsClicked et donc changer la couleur de fond de l'image (dans Adapter)
        pAdapter.notifyDataSetChanged();
        //ajout de l'aliment à la liste si il n'existe pas déja dedans
    }
    public void unCheckItem(Aliment pAlim, Adapter pAdapter){
        Result.deleteAliment(pAlim.getName());
        pAlim.setIsClicked(false);
        // On demande l'actualisation de l'affichage à l'adapter qui va vérifier chaque valeur de IsClicked et donc changer la couleur de fond de l'image (dans Adapter)
        pAdapter.notifyDataSetChanged();
    }
}
