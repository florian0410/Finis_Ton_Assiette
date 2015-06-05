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
public class Incontournable extends AlimentListDisplayer {
    private HashMap<String, Integer> hashMapIncontournable= new HashMap<String, Integer>();
    private GridView lv;
    private Button boutonfin = null;

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

        /*
        Création de la Hashmap hashMapIncontournable
         */

        hashMapIncontournable.put(getString(R.string.Ail), R.drawable.ic_ailtransparent);
        hashMapIncontournable.put(getString(R.string.Beurre_margarine), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Chocolat), R.drawable.ic_chocolattransparent);
        hashMapIncontournable.put(getString(R.string.Crème_fraiche), R.drawable.ic_cremefraichetransparent);
        hashMapIncontournable.put(getString(R.string.Eau), R.drawable.ic_eautransparent);
        hashMapIncontournable.put(getString(R.string.Farine_de_blé), R.drawable.ic_farine_transparent);
        hashMapIncontournable.put(getString(R.string.Gruyére_emmental), R.drawable.ic_gruyeretransparent);
        hashMapIncontournable.put(getString(R.string.Huile_d_olive), R.drawable.ic_huileolivetransparent);
        hashMapIncontournable.put(getString(R.string.Huile_de_tournesol), R.drawable.ic_huile_tournesol_transparente);
        hashMapIncontournable.put(getString(R.string.Lait), R.drawable.ic_bouteillelaittransparent);
        hashMapIncontournable.put(getString(R.string.Miel), R.drawable.ic_pot_mieltransparent);
        hashMapIncontournable.put(getString(R.string.Oeuf), R.drawable.ic_oeufs_tourgris_transparent);
        hashMapIncontournable.put(getString(R.string.Oignon), R.drawable.ic_oignontransparent);
        hashMapIncontournable.put(getString(R.string.Pâte_brisée), R.drawable.ic_pates_briseetransparent);
        hashMapIncontournable.put(getString(R.string.Pâte_feuilletée), R.drawable.ic_patefeuilletetransparentegrand);
        hashMapIncontournable.put(getString(R.string.Pâtes), R.drawable.ic_paquetpatestransparent);
        hashMapIncontournable.put(getString(R.string.Poivre), R.drawable.ic_poivretransparent);
        hashMapIncontournable.put(getString(R.string.Pomme_de_terre), R.drawable.ic_pommedeterre2transparent);
        hashMapIncontournable.put(getString(R.string.Riz_blanc), R.drawable.ic_bolriztransparent);
        hashMapIncontournable.put(getString(R.string.Sel), R.drawable.ic_seltransparent);
        hashMapIncontournable.put(getString(R.string.Sucre), R.drawable.ic_sucretransparent);
        hashMapIncontournable.put(getString(R.string.Tomate), R.drawable.ic_tomatetransparent);
        hashMapIncontournable.put(getString(R.string.Vinaigre_balsamique), R.drawable.ic_vinaigretransparent);
        hashMapIncontournable.put(getString(R.string.Yaourt_nature), R.drawable.ic_yaourttransparent);
        hashMapIncontournable.put(getString(R.string.sucre_glace), R.drawable.ic_sucre_glacetransparent);
        hashMapIncontournable.put(getString(R.string.moutarde), R.drawable.ic_moutardetransparente);




        arrayListAlimentsDisplayer = ListeAliment.alimentsArraylist(hashMapIncontournable);
        // On déclare ici l'adapteur pour pouvoir faire fonctionner la méthode notifyDataSetChanged
        myAdapter = new Adapter(arrayListAlimentsDisplayer, super.context);
        lv.setAdapter(myAdapter);

        // Listener pour sélection des aliments
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlimentDisplayer alim = arrayListAlimentsDisplayer.get(position);
                if (alim.isClicked() == false) {
                    CheckItem(alim,myAdapter);
                } else {
                    unCheckItem(alim,myAdapter);
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


