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
public class Viande extends Activity {
    private HashMap<String, Integer> hashMapViande = new HashMap<String, Integer>();
    private ArrayList<Aliment> arrayListAliments;
    private GridView lv;
    private Context context=Viande.this;
    private List<String> result;

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
                    alim.setIsClicked(true);
                    //ajout de l'aliment à la liste si il n'existe pas déja dedans

                    result.add(alim.getName());
                } else {
                    alim.setIsClicked(true);
                    result.remove(alim.getName());
                }

            }
        });
        /*
        Création de la Hashmap hashMapViande
         */

        hashMapViande.put(getString(R.string.Agneau), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Boeuf), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Boudin_blanc), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Boudin_noir), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Caille), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Dinde), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Escargots), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Foie_gras), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Jambon_blanc), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Jambon_cru), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Jambon_fumé), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Lapin), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Lard_Lardons), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Merguez), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Mouton), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Oeufs_à_la_caille), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Os_à_moëlle), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Porc), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Poulet), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Quenelles), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Saucisse), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Saucisson), R.drawable.ic_beurretransparent);
        hashMapViande.put(getString(R.string.Veau), R.drawable.ic_beurretransparent);
        result= new ArrayList<String>();

        arrayListAliments = ListeAliment.alimentsArraylist(hashMapViande);
        lv.setAdapter(new Adapter(arrayListAliments, context));
    }
}
