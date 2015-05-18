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
public class Poisson extends Activity {

    private final  HashMap<String, Integer> HashPoisson = new HashMap<String, Integer>();
    private ArrayList<Aliment> arrayListAliments;
    private GridView lv;
    private Context context=Poisson.this;



    protected void onCreate(Bundle savedInstanceState){
        // Remplissage de la HashMap associant le nom de l'aliment (clé) et son image (objet renvoyé par clé)
        HashPoisson.put(getString(R.string.Cabillaud), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Calamars), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Colin), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Crevettes), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Daurade), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Flétan), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Gambas), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Haddock), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Hareng), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Lieu), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Maquerau), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Merlu), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Moules), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Oeufs_de_lump), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Saint_Jacques), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Sardines), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Saumon), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Saumon_fumé), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Sole), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Surimi), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Thon_en_boite), R.drawable.ic_beurretransparent);
        HashPoisson.put(getString(R.string.Truite), R.drawable.ic_beurretransparent);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        lv = (GridView) findViewById(R.id.ListViewAliment);
        arrayListAliments = ListeAliment.alimentsArraylist(HashPoisson);
        lv.setAdapter(new Adapter(arrayListAliments,context));
    }


}
