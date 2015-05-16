package zlisproduction.finistonassiette.selectionaliments;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
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

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        /*
        Création de la HashMap poisson
         */
        hashMapCereales.put("blé", R.mipmap.ic_launcher);
        hashMapCereales.put("boulghour", R.mipmap.ic_launcher);
        hashMapCereales.put( "farine de froment",R.mipmap.ic_launcher);
        hashMapCereales.put("lasagnes",R.mipmap.ic_launcher);
        hashMapCereales.put("müesli",R.mipmap.ic_launcher);
        hashMapCereales.put("pâtes de riz",R.mipmap.ic_launcher);
        hashMapCereales.put("quinoa",R.mipmap.ic_launcher);
        hashMapCereales.put("riz complet",R.mipmap.ic_launcher);
        hashMapCereales.put("sarrazin",R.mipmap.ic_launcher);

        //layout de l'activité
        lv = (GridView) findViewById(R.id.ListViewAliment);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setAlpha(75);
                view.setBackgroundColor(Color.GRAY);
            }
        });
        //fabrication de l'objet aliment
        arrayListAliments = ListeAliment.alimentsArraylist(hashMapCereales);
        //mis en page
        lv.setAdapter(new Adapter(arrayListAliments,context));
    }

}
