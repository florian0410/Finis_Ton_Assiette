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
public class Legume extends Activity {

    private HashMap<String, Integer> hashMapLegumes= new HashMap<String, Integer>();
    private ArrayList<Aliment> arrayListAliments;
    private GridView lv;
    private Context context=Legume.this;



    protected void onCreate(Bundle savedInstanceState){
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
        Création de la Hashmap hashMapLegumes
         */

        hashMapLegumes.put(getString(R.string.Artichaut), R.drawable.ic_1courgettetransparente);
        hashMapLegumes.put(getString(R.string.Aubergine),R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Avocat), R.drawable.ic_1courgettetransparente);
        hashMapLegumes.put(getString(R.string.Betterave),R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Brocoli), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Carotte), R.drawable.ic_1courgettetransparente);
        hashMapLegumes.put(getString(R.string.chou_blanc_ou_vert), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.chou_fleur), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Choux_de_Bruxelles), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Coeur_de_palmier), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Concombre), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Courgette), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Épinards), R.drawable.ic_1courgettetransparente);
        hashMapLegumes.put(getString(R.string.Fenouil), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Flageolets), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Germes_de_soja), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Haricots_verts), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Lentilles), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Maïs), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Navet), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Olives_noires), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Olives_vertes), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Patate_douce), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Petits_pois), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Poireau), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Pois_cassés), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Pois_chiches), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Pois_gourmands), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Poivron), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Potimarron), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Potiron), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Radis), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Salade_verte), R.drawable.ic_beurretransparent);
        hashMapLegumes.put(getString(R.string.Tomate_verte), R.drawable.ic_beurretransparent);

        arrayListAliments = ListeAliment.alimentsArraylist(hashMapLegumes);
        lv.setAdapter(new Adapter(arrayListAliments,context));
    }


}
