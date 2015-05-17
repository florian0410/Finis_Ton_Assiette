package zlisproduction.finistonassiette.selectionaliments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.HashMap;

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
    private Button boutonfin;


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

        //Récupération du bouton
        boutonfin=(Button)findViewById(R.id.finselection);
        boutonfin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                transfert des résultats
                 */

                finish();
            }
        });
        //layout de l'activité
        lv = (GridView) findViewById(R.id.ListViewAliment);
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
