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
import java.util.Iterator;
import java.util.List;

import zlisproduction.finistonassiette.R;

/**
 * Created by Florian on 15/05/2015.
 */
public class Cereale extends Activity {

    private  HashMap <String, Integer> hashMapCereales= new HashMap <String, Integer>();
    private ArrayList<Aliment> arrayListAliments;
    private GridView lv;
    private Context context=Cereale.this;
    private ArrayList<Aliment> alimentsSelectionnes= new ArrayList<Aliment>();
    private List<String> result;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        /*
        Création de la HashMap poisson
         */
        hashMapCereales.put(getString(R.string.Blé), R.drawable.ic_beurretransparent);
        hashMapCereales.put(getString(R.string.Boulghour), R.drawable.ic_beurretransparent);
        hashMapCereales.put(getString(R.string.Farine_de_froment), R.drawable.ic_beurretransparent);
        hashMapCereales.put(getString(R.string.Lasagnes), R.drawable.ic_beurretransparent);
        hashMapCereales.put(getString(R.string.Müesli), R.drawable.ic_beurretransparent);
        hashMapCereales.put(getString(R.string.Pâtes_de_riz), R.drawable.ic_beurretransparent);
        hashMapCereales.put(getString(R.string.Quinoa), R.drawable.ic_beurretransparent);
        hashMapCereales.put(getString(R.string.Riz_complet), R.drawable.ic_beurretransparent);
        hashMapCereales.put(getString(R.string.Sarrasin), R.drawable.ic_beurretransparent);

        result= new ArrayList<String>();
        //layout de l'activité
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
        //fabrication de l'objet aliment
        arrayListAliments = ListeAliment.alimentsArraylist(hashMapCereales);
        //mis en page
        lv.setAdapter(new Adapter(arrayListAliments,context));

        /*lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Aliment alim = arrayListAliments.get(position);
                if(alim.isClicked()==false){
                    view.setBackgroundColor(Color.GRAY);
                    alimentsSelectionnes.add(alim);
                    alim.setIsClicked(true);
                }
                else{

                    arrayListAliments.remove(position);
                    view.setBackgroundColor(Color.RED);
                    alim.setIsClicked(false);

                }
            }
        });

        */


    }



}
