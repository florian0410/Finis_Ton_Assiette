package zlisproduction.finistonassiette.selectionaliments;

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
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import zlisproduction.finistonassiette.R;

/**
 * Created by Florian on 15/05/2015.
 */
public class Incontournable extends Fragment {
    private HashMap<String, Integer> hashMapIncontournable= new HashMap<String, Integer>();
    private ArrayList<Aliment> arrayListAliments;
    private GridView lv;
    private Context context=getActivity();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // FragmentActivity    faActivity  = (FragmentActivity)    super.getActivity();
        // Replace LinearLayout by the type of the root element of the layout you're trying to load
        View lLayout = inflater.inflate(R.layout.listview, container, false);
        // Of course you will want to faActivity and llLayout in the class and not this method to access them in the rest of
        // the class, just initialize them here

        lv = (GridView) lLayout.findViewById(R.id.ListViewAliment);

        /*
        Création de la Hashmap hashMapIncontournable
         */

        hashMapIncontournable.put(getString(R.string.Ail), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Beurre_margarine), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Chocolat), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Crème_fraiche), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Eau), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Farine_de_blé), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Gruyére_emmental), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Huile_d_olive), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Huile_de_tournesol), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Lait), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Miel), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Oeuf), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Oignon), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Pâte_brisée), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Pâte_feuilletée), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Pâtes), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Poivre), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Pomme_de_terre), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Riz_blanc), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Sel), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Sucre), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Tomate), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Vinaigre_balsamique), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Yaourt_nature), R.drawable.ic_beurretransparent);


        arrayListAliments = ListeAliment.alimentsArraylist(hashMapIncontournable);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Aliment alim = arrayListAliments.get(position);
                if (alim.isClicked() == false) {
                    //Si l'aliment n'est pas coché on le met dans la liste des résultats et on le met coché
                    Result.setAlimentsSelectionnes(alim.getName());
                    alim.setIsClicked(true);
                    //ajout de l'aliment à la liste si il n'existe pas déja dedans

                }
                else {
                    Result.deleteAliment(alim.getName());
                    alim.setIsClicked(true);
                }
            }
        });
        lv.setAdapter(new Adapter(arrayListAliments,context));

        return lLayout;
    }
   /* protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        lv = (GridView) findViewById(R.id.ListViewAliment);

        hashMapIncontournable.put(getString(R.string.Ail), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Beurre_margarine), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Chocolat), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Crème_fraiche), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Eau), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Farine_de_blé), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Gruyére_emmental), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Huile_d_olive), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Huile_de_tournesol), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Lait), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Miel), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Oeuf), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Oignon), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Pâte_brisée), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Pâte_feuilletée), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Pâtes), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Poivre), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Pomme_de_terre), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Riz_blanc), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Sel), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Sucre), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Tomate), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Vinaigre_balsamique), R.drawable.ic_beurretransparent);
        hashMapIncontournable.put(getString(R.string.Yaourt_nature), R.drawable.ic_beurretransparent);


        arrayListAliments = ListeAliment.alimentsArraylist(hashMapIncontournable);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Aliment alim = arrayListAliments.get(position);
                if (alim.isClicked() == false) {
                    //Si l'aliment n'est pas coché on le met dans la liste des résultats et on le met coché
                    Result.setAlimentsSelectionnes(alim.getName());
                    alim.setIsClicked(true);
                    //ajout de l'aliment à la liste si il n'existe pas déja dedans

                }
                else {
                    Result.deleteAliment(alim.getName());
                    alim.setIsClicked(true);
                }
            }
        });
        lv.setAdapter(new Adapter(arrayListAliments,context));
    }
    */
}
