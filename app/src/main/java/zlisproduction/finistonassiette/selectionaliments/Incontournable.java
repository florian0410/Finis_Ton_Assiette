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
public class Incontournable extends Activity {
    private HashMap<String, Integer> hashMapIncontournable= new HashMap<String, Integer>();
    private ArrayList<Aliment> arrayListAliments;
    private GridView lv;
    private Button boutonfin;

    private Context context=Incontournable.this;

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
        Création de la Hashmap hashMapIncontournable
         */

        hashMapIncontournable.put(getString(R.string.Ail), R.mipmap.ic_launcher);
        hashMapIncontournable.put(getString(R.string.Beurre_margarine), R.mipmap.ic_launcher);
        hashMapIncontournable.put(getString(R.string.Chocolat), R.mipmap.ic_launcher);
        hashMapIncontournable.put(getString(R.string.Crème_fraiche), R.mipmap.ic_launcher);
        hashMapIncontournable.put(getString(R.string.Eau), R.mipmap.ic_launcher);
        hashMapIncontournable.put(getString(R.string.Farine_de_blé), R.mipmap.ic_launcher);
        hashMapIncontournable.put(getString(R.string.Gruyére_emmental), R.mipmap.ic_launcher);
        hashMapIncontournable.put(getString(R.string.Huile_d_olive), R.mipmap.ic_launcher);
        hashMapIncontournable.put(getString(R.string.Huile_de_tournesol), R.mipmap.ic_launcher);
        hashMapIncontournable.put(getString(R.string.Lait), R.mipmap.ic_launcher);
        hashMapIncontournable.put(getString(R.string.Miel), R.mipmap.ic_launcher);
        hashMapIncontournable.put(getString(R.string.Oeuf), R.mipmap.ic_launcher);
        hashMapIncontournable.put(getString(R.string.Oignon), R.mipmap.ic_launcher);
        hashMapIncontournable.put(getString(R.string.Pâte_brisée), R.mipmap.ic_launcher);
        hashMapIncontournable.put(getString(R.string.Pâte_feuilletée), R.mipmap.ic_launcher);
        hashMapIncontournable.put(getString(R.string.Pâtes), R.mipmap.ic_launcher);
        hashMapIncontournable.put(getString(R.string.Poivre), R.mipmap.ic_launcher);
        hashMapIncontournable.put(getString(R.string.Pomme_de_terre), R.mipmap.ic_launcher);
        hashMapIncontournable.put(getString(R.string.Riz_blanc), R.mipmap.ic_launcher);
        hashMapIncontournable.put(getString(R.string.Sel), R.mipmap.ic_launcher);
        hashMapIncontournable.put(getString(R.string.Sucre), R.mipmap.ic_launcher);
        hashMapIncontournable.put(getString(R.string.Tomate), R.mipmap.ic_launcher);
        hashMapIncontournable.put(getString(R.string.Vinaigre_balsamique), R.mipmap.ic_launcher);
        hashMapIncontournable.put(getString(R.string.Yaourt_nature), R.mipmap.ic_launcher);

        arrayListAliments = ListeAliment.alimentsArraylist(hashMapIncontournable);
        lv.setAdapter(new Adapter(arrayListAliments,context));
    }
}
