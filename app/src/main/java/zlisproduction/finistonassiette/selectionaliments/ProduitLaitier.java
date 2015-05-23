package zlisproduction.finistonassiette.selectionaliments;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import zlisproduction.finistonassiette.R;

/**
 * Created by Florian on 15/05/2015.
 */
public class ProduitLaitier extends Fragment {
    private HashMap<String, Integer> hashMapProduitLaitier = new HashMap<String, Integer>();
    private ArrayList<Aliment> arrayListAliments;
    private GridView lv;
    private Context context = null;


    /*
    * Fonction permettant d'obtenir le contexte de l'activité principal, si on ne le récupére pas alors le contexte fourni
    * dans la méthode setAdapter(Context) auraz un contexte null qui fera échouer le chargement de la vue.
    * @param : L'activité en cours qui nous permettra de récupérer son contexte
    */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = activity.getApplicationContext();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Changer le titre de la barre d'action
        ActionBar actionbar = getActivity().getActionBar();
        actionbar.setTitle(getResources().getString(R.string.Produits_Laitier));
        // FragmentActivity faActivity  = (FragmentActivity)    super.getActivity();
        // Replace LinearLayout by the type of the root element of the layout you're trying to load
        View lLayout = inflater.inflate(R.layout.listview, container, false);
        // Of course you will want to faActivity and llLayout in the class and not this method to access them in the rest of
        // the class, just initialize them here
        lv = (GridView) lLayout.findViewById(R.id.ListViewAliment);
        /*
        Création de la Hashmap hashMapIncontournable
         */
        hashMapProduitLaitier.put(getString(R.string.Brie), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(getString(R.string.Camembert), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(getString(R.string.Cantal), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(getString(R.string.Chévre_Brebis), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(getString(R.string.Comté), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(getString(R.string.Feta), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(getString(R.string.Fromage_blanc), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(getString(R.string.Lait_de_coco), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(getString(R.string.Lait_de_soja), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(getString(R.string.Mascarpone), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(getString(R.string.Mont_d_Or), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(getString(R.string.Mozarella), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(getString(R.string.Parmesan), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(getString(R.string.Petits_suisses), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(getString(R.string.Raclette), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(getString(R.string.Roquefort), R.drawable.ic_beurretransparent);
        hashMapProduitLaitier.put(getString(R.string.Saint_Marcelin), R.drawable.ic_beurretransparent);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Aliment alim = arrayListAliments.get(position);
                if (alim.isClicked() == false) {
                    //Si l'aliment n'est pas coché on le met dans la liste des résultats et on le met coché
                    Result.setAlimentsSelectionnes(alim.getName());
                    alim.setIsClicked(true);
                    //ajout de l'aliment à la liste si il n'existe pas déja dedans
                } else {
                    Result.deleteAliment(alim.getName());
                    alim.setIsClicked(true);
                }
            }
        });
        arrayListAliments = ListeAliment.alimentsArraylist(hashMapProduitLaitier);
        lv.setAdapter(new Adapter(arrayListAliments, context));
        return lLayout;
    }
}
