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
public class ProduitLaitier extends AppCompatActivity {
    private HashMap<String, Integer> hashMapProduitLaitier = new HashMap<String, Integer>();
    private ArrayList<Aliment> arrayListAliments;
    private GridView lv;
    private Context context=ProduitLaitier.this;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        lv = (GridView) findViewById(R.id.ListViewAliment);
        /*
        Création de la Hashmap hashMapProduitLaitier
         */

        hashMapProduitLaitier.put(getString(R.string.Brie), R.mipmap.ic_launcher);
        hashMapProduitLaitier.put(getString(R.string.Camembert), R.mipmap.ic_launcher);
        hashMapProduitLaitier.put(getString(R.string.Cantal), R.mipmap.ic_launcher);
        hashMapProduitLaitier.put(getString(R.string.Chévre_Brebis), R.mipmap.ic_launcher);
        hashMapProduitLaitier.put(getString(R.string.Comté), R.mipmap.ic_launcher);
        hashMapProduitLaitier.put(getString(R.string.Feta), R.mipmap.ic_launcher);
        hashMapProduitLaitier.put(getString(R.string.Fromage_blanc), R.mipmap.ic_launcher);
        hashMapProduitLaitier.put(getString(R.string.Lait_de_coco), R.mipmap.ic_launcher);
        hashMapProduitLaitier.put(getString(R.string.Lait_de_soja), R.mipmap.ic_launcher);
        hashMapProduitLaitier.put(getString(R.string.Mascarpone), R.mipmap.ic_launcher);
        hashMapProduitLaitier.put(getString(R.string.Mont_d_Or), R.mipmap.ic_launcher);
        hashMapProduitLaitier.put(getString(R.string.Mozarella), R.mipmap.ic_launcher);
        hashMapProduitLaitier.put(getString(R.string.Parmesan), R.mipmap.ic_launcher);
        hashMapProduitLaitier.put(getString(R.string.Petits_suisses), R.mipmap.ic_launcher);
        hashMapProduitLaitier.put(getString(R.string.Raclette), R.mipmap.ic_launcher);
        hashMapProduitLaitier.put(getString(R.string.Roquefort), R.mipmap.ic_launcher);
        hashMapProduitLaitier.put(getString(R.string.Saint_Marcelin), R.mipmap.ic_launcher);

        arrayListAliments = ListeAliment.alimentsArraylist(hashMapProduitLaitier);
        lv.setAdapter(new Adapter(arrayListAliments, context));
    }
}
