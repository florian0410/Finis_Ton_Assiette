package zlisproduction.finistonassiette.selectionaliments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
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
public class ProduitLaitier extends Activity {
    private HashMap<String, Integer> hashMapProduitLaitier = new HashMap<String, Integer>();
    private ArrayList<Aliment> arrayListAliments;
    private GridView lv;
    private Context context=ProduitLaitier.this;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);


        lv = (GridView) findViewById(R.id.ListViewAliment);
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
        /*
        Création de la Hashmap hashMapProduitLaitier
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

        arrayListAliments = ListeAliment.alimentsArraylist(hashMapProduitLaitier);
        lv.setAdapter(new Adapter(arrayListAliments, context));
    }
}
