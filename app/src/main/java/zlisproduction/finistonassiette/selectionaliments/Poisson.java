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
public class Poisson extends AppCompatActivity{

    private final  HashMap<String, Integer> HashPoisson = new HashMap<String, Integer>();

    private ArrayList<Aliment> arrayListAliments;
    private GridView lv;
    private Context context=Poisson.this;

    protected void onCreate(Bundle savedInstanceState){
        // Remplissage de la HashMap associant le nom de l'aliment (clé) et son image (objet renvoyé par clé)
        HashPoisson.put(getString(R.string.Cabillaud),R.mipmap.ic_launcher);
        HashPoisson.put(getString(R.string.Calamars),R.mipmap.ic_launcher);
        HashPoisson.put(getString(R.string.Colin),R.mipmap.ic_launcher);
        HashPoisson.put(getString(R.string.Crevettes),R.mipmap.ic_launcher);
        HashPoisson.put(getString(R.string.Daurade),R.mipmap.ic_launcher);
        HashPoisson.put(getString(R.string.Flétan),R.mipmap.ic_launcher);
        HashPoisson.put(getString(R.string.Gambas),R.mipmap.ic_launcher);
        HashPoisson.put(getString(R.string.Haddock),R.mipmap.ic_launcher);
        HashPoisson.put(getString(R.string.Hareng),R.mipmap.ic_launcher);
        HashPoisson.put(getString(R.string.Lieu),R.mipmap.ic_launcher);
        HashPoisson.put(getString(R.string.Maquerau),R.mipmap.ic_launcher);
        HashPoisson.put(getString(R.string.Merlu),R.mipmap.ic_launcher);
        HashPoisson.put(getString(R.string.Moules),R.mipmap.ic_launcher);
        HashPoisson.put(getString(R.string.Oeufs_de_lump),R.mipmap.ic_launcher);
        HashPoisson.put(getString(R.string.Saint_Jacques),R.mipmap.ic_launcher);
        HashPoisson.put(getString(R.string.Sardines),R.mipmap.ic_launcher);
        HashPoisson.put(getString(R.string.Saumon),R.mipmap.ic_launcher);
        HashPoisson.put(getString(R.string.Saumon_fumé),R.mipmap.ic_launcher);
        HashPoisson.put(getString(R.string.Sole),R.mipmap.ic_launcher);
        HashPoisson.put(getString(R.string.Surimi),R.mipmap.ic_launcher);
        HashPoisson.put(getString(R.string.Thon_en_boite),R.mipmap.ic_launcher);
        HashPoisson.put(getString(R.string.Truite),R.mipmap.ic_launcher);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        lv = (GridView) findViewById(R.id.ListViewAliment);
        arrayListAliments = ListeAliment.alimentsArraylist(HashPoisson);
        lv.setAdapter(new Adapter(arrayListAliments,context));
    }


}
