package zlisproduction.finistonassiette.selectionaliments;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.HashMap;

import zlisproduction.finistonassiette.R;

/**
 * Created by Florian on 15/05/2015.
 */
public class Viande extends AppCompatActivity {
    private HashMap<String, Integer> hashMapViande = new HashMap<String, Integer>();
    private ArrayList<Aliment> arrayListAliments;
    private GridView lv;
    private Context context=Viande.this;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        lv = (GridView) findViewById(R.id.ListViewAliment);
        /*
        Création de la Hashmap hashMapViande
         */

        hashMapViande.put(getString(R.string.Agneau), R.mipmap.ic_launcher);
        hashMapViande.put(getString(R.string.Boeuf), R.mipmap.ic_launcher);
        hashMapViande.put(getString(R.string.Boudin_blanc), R.mipmap.ic_launcher);
        hashMapViande.put(getString(R.string.Boudin_noir), R.mipmap.ic_launcher);
        hashMapViande.put(getString(R.string.Caille), R.mipmap.ic_launcher);
        hashMapViande.put(getString(R.string.Dinde), R.mipmap.ic_launcher);
        hashMapViande.put(getString(R.string.Escargots), R.mipmap.ic_launcher);
        hashMapViande.put(getString(R.string.Foie_gras), R.mipmap.ic_launcher);
        hashMapViande.put(getString(R.string.Jambon_blanc), R.mipmap.ic_launcher);
        hashMapViande.put(getString(R.string.Jambon_cru), R.mipmap.ic_launcher);
        hashMapViande.put(getString(R.string.Jambon_fumé), R.mipmap.ic_launcher);
        hashMapViande.put(getString(R.string.Lapin), R.mipmap.ic_launcher);
        hashMapViande.put(getString(R.string.Lard_Lardons), R.mipmap.ic_launcher);
        hashMapViande.put(getString(R.string.Merguez), R.mipmap.ic_launcher);
        hashMapViande.put(getString(R.string.Mouton), R.mipmap.ic_launcher);
        hashMapViande.put(getString(R.string.Oeufs_à_la_caille), R.mipmap.ic_launcher);
        hashMapViande.put(getString(R.string.Os_à_moëlle), R.mipmap.ic_launcher);
        hashMapViande.put(getString(R.string.Porc), R.mipmap.ic_launcher);
        hashMapViande.put(getString(R.string.Poulet), R.mipmap.ic_launcher);
        hashMapViande.put(getString(R.string.Quenelles), R.mipmap.ic_launcher);
        hashMapViande.put(getString(R.string.Saucisse), R.mipmap.ic_launcher);
        hashMapViande.put(getString(R.string.Saucisson), R.mipmap.ic_launcher);
        hashMapViande.put(getString(R.string.Veau), R.mipmap.ic_launcher);

        arrayListAliments = ListeAliment.alimentsArraylist(hashMapViande);
        lv.setAdapter(new Adapter(arrayListAliments, context));
    }
}
