package zlisproduction.finistonassiette.selectionaliments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.HashMap;

import zlisproduction.finistonassiette.R;

/**
 * Created by Florian on 15/05/2015.
 */
public class Legume extends Activity {

    private HashMap<String, Integer> hashMapLegumes= new HashMap<String, Integer>();
    private ArrayList<Aliment> arrayListAliments;
    private GridView lv;
    private Context context=Legume.this;
    private Button boutonfin;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        boutonfin=(Button)findViewById(R.id.finselection);
        boutonfin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        lv = (GridView) findViewById(R.id.ListViewAliment);
        /*
        Création de la Hashmap hashMapLegumes
         */

        hashMapLegumes.put(getString(R.string.Artichaut), R.mipmap.ic_launcher);
        hashMapLegumes.put(getString(R.string.Aubergine), R.mipmap.ic_launcher);
        hashMapLegumes.put(getString(R.string.Avocat), R.mipmap.ic_launcher);
        hashMapLegumes.put(getString(R.string.Betterave), R.mipmap.ic_launcher);
        hashMapLegumes.put(getString(R.string.Brocoli), R.mipmap.ic_launcher);
        hashMapLegumes.put(getString(R.string.Carotte), R.mipmap.ic_launcher);
        hashMapLegumes.put(getString(R.string.chou_blanc_ou_vert), R.mipmap.ic_launcher);
        hashMapLegumes.put(getString(R.string.chou_fleur), R.mipmap.ic_launcher);
        hashMapLegumes.put(getString(R.string.Choux_de_Bruxelles), R.mipmap.ic_launcher);
        hashMapLegumes.put(getString(R.string.Coeur_de_palmier), R.mipmap.ic_launcher);
        hashMapLegumes.put(getString(R.string.Concombre), R.mipmap.ic_launcher);
        hashMapLegumes.put(getString(R.string.Courgette), R.mipmap.ic_launcher);
        hashMapLegumes.put(getString(R.string.Épinards), R.mipmap.ic_launcher);
        hashMapLegumes.put(getString(R.string.Fenouil), R.mipmap.ic_launcher);
        hashMapLegumes.put(getString(R.string.Flageolets), R.mipmap.ic_launcher);
        hashMapLegumes.put(getString(R.string.Germes_de_soja), R.mipmap.ic_launcher);
        hashMapLegumes.put(getString(R.string.Haricots_verts), R.mipmap.ic_launcher);
        hashMapLegumes.put(getString(R.string.Lentilles), R.mipmap.ic_launcher);
        hashMapLegumes.put(getString(R.string.Maïs), R.mipmap.ic_launcher);
        hashMapLegumes.put(getString(R.string.Navet), R.mipmap.ic_launcher);
        hashMapLegumes.put(getString(R.string.Olives_noires), R.mipmap.ic_launcher);
        hashMapLegumes.put(getString(R.string.Olives_vertes), R.mipmap.ic_launcher);
        hashMapLegumes.put(getString(R.string.Patate_douce), R.mipmap.ic_launcher);
        hashMapLegumes.put(getString(R.string.Petits_pois), R.mipmap.ic_launcher);
        hashMapLegumes.put(getString(R.string.Poireau), R.mipmap.ic_launcher);
        hashMapLegumes.put(getString(R.string.Pois_cassés), R.mipmap.ic_launcher);
        hashMapLegumes.put(getString(R.string.Pois_chiches), R.mipmap.ic_launcher);
        hashMapLegumes.put(getString(R.string.Pois_gourmands), R.mipmap.ic_launcher);
        hashMapLegumes.put(getString(R.string.Poivron), R.mipmap.ic_launcher);
        hashMapLegumes.put(getString(R.string.Potimarron), R.mipmap.ic_launcher);
        hashMapLegumes.put(getString(R.string.Potiron), R.mipmap.ic_launcher);
        hashMapLegumes.put(getString(R.string.Radis), R.mipmap.ic_launcher);
        hashMapLegumes.put(getString(R.string.Salade_verte), R.mipmap.ic_launcher);
        hashMapLegumes.put(getString(R.string.Tomate_verte), R.mipmap.ic_launcher);

        arrayListAliments = ListeAliment.alimentsArraylist(hashMapLegumes);
        lv.setAdapter(new Adapter(arrayListAliments,context));
    }


}
