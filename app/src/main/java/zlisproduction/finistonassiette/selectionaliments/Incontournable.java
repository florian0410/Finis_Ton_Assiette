package zlisproduction.finistonassiette.selectionaliments;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import zlisproduction.finistonassiette.R;
import zlisproduction.finistonassiette.adapter.Adapter;
import zlisproduction.finistonassiette.recette.ConstructeurDefaut;
import zlisproduction.finistonassiette.recette.ConsulterRecette;
import zlisproduction.finistonassiette.recette.Information;
import zlisproduction.finistonassiette.recette.JsonFormat;

/**
 * Created by Florian on 15/05/2015.
 */
public class Incontournable extends AlimentListDisplayer implements View.OnClickListener{

    private GridView lv;
    private Button boutonfin = null;
    private TextView chargement =  null;
    private boolean bool =false;

    /*
     * Fonction permettant d'obtenir le contexte de l'activité principal, si on ne le récupére pas alors le contexte fourni
     * dans la méthode setAdapter(Context) auraz un contexte null qui fera échouer le chargement de la vue.
     * @param : L'activité en cours qui nous permettra de récupérer son contexte
     */
    /*@Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = activity.getApplicationContext();
    }
    */

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
        boutonfin = (Button) lLayout.findViewById(R.id.boutonfinselection);
        chargement =(TextView) lLayout.findViewById(R.id.chargement);
        Aliment alim = new Aliment(context);
        //fabrication de l'objet aliment
        arrayListAlimentsDisplayer = ListeAliment.alimentsArraylist(alim.getHashMapAlimentFromCategorie(getString(R.string.Incontournable)));
        // On déclare ici l'adapteur pour pouvoir faire fonctionner la méthode notifyDataSetChanged
        myAdapter = new Adapter(arrayListAlimentsDisplayer, super.context);

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

        /**
         * Lance une demande de consultation de requête en fonction des aliment présents la variable statique aliment de la classe CreateListAliment
         * @see CreateListAliment
         */
        boutonfin.setOnClickListener(this);

        lv.setAdapter(myAdapter);
        return lLayout;
    }

    /**
     * Réalise la requête si la liste des aliments séléctionnée n'est pas vierge. Sinon on affiche un toast
     * @param v
     */
    @Override
    public void onClick(View v) {

        CreateListAliment.getAlimList(context);
        // Retour au menu principal
        // Plus tard ce sera affichage de la liste des résultats


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
}


