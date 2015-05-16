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
public class Incontournable extends AppCompatActivity{
    private HashMap<String, Integer> hashMapIncontournable= new HashMap<String, Integer>();
    private ArrayList<Aliment> arrayListAliments;
    private GridView lv;

    private Context context=Incontournable.this;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        lv = (GridView) findViewById(R.id.ListViewAliment);
        /*
        Création de la Hashmap hashMapIncontournable
         */

        hashMapIncontournable.put("ail", R.mipmap.ic_launcher);
        hashMapIncontournable.put("beurre, margarine", R.mipmap.ic_launcher);
        hashMapIncontournable.put("chocolat", R.mipmap.ic_launcher);
        hashMapIncontournable.put("crème fraîche", R.mipmap.ic_launcher);
        hashMapIncontournable.put("eau", R.mipmap.ic_launcher);
        hashMapIncontournable.put("farine de blé", R.mipmap.ic_launcher);
        hashMapIncontournable.put("gruyère, emmental", R.mipmap.ic_launcher);
        hashMapIncontournable.put("huile d'olive", R.mipmap.ic_launcher);
        hashMapIncontournable.put("huile de tournesol", R.mipmap.ic_launcher);
        hashMapIncontournable.put("lait", R.mipmap.ic_launcher);
        hashMapIncontournable.put("miel", R.mipmap.ic_launcher);
        hashMapIncontournable.put("oeuf(s)", R.mipmap.ic_launcher);
        hashMapIncontournable.put("oignons", R.mipmap.ic_launcher);
        hashMapIncontournable.put("pâte brisée", R.mipmap.ic_launcher);
        hashMapIncontournable.put("pâte feuilletée", R.mipmap.ic_launcher);
        hashMapIncontournable.put("pâtes", R.mipmap.ic_launcher);
        hashMapIncontournable.put("poivre", R.mipmap.ic_launcher);
        hashMapIncontournable.put("pomme(s) de terre", R.mipmap.ic_launcher);
        hashMapIncontournable.put("riz blanc", R.mipmap.ic_launcher);
        hashMapIncontournable.put("sel", R.mipmap.ic_launcher);
        hashMapIncontournable.put("sucre", R.mipmap.ic_launcher);
        hashMapIncontournable.put("tomate(s)", R.mipmap.ic_launcher);
        hashMapIncontournable.put("vinaigre balsamique", R.mipmap.ic_launcher);
        hashMapIncontournable.put("yaourt nature", R.mipmap.ic_launcher);

        arrayListAliments = ListeAliment.alimentsArraylist(hashMapIncontournable);
        lv.setAdapter(new Adapter(arrayListAliments,context));
    }
}
