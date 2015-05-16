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
        HashPoisson.put("Cabillaud",R.mipmap.ic_launcher);
        HashPoisson.put("Calamars",R.mipmap.ic_launcher);
        HashPoisson.put("Colin",R.mipmap.ic_launcher);
        HashPoisson.put("Crevettes",R.mipmap.ic_launcher);
        HashPoisson.put("Daurade",R.mipmap.ic_launcher);
        HashPoisson.put("Flétan",R.mipmap.ic_launcher);
        HashPoisson.put("Gambas",R.mipmap.ic_launcher);
        HashPoisson.put("Haddock",R.mipmap.ic_launcher);
        HashPoisson.put("Hareng",R.mipmap.ic_launcher);
        HashPoisson.put("Lieu",R.mipmap.ic_launcher);
        HashPoisson.put("Maquerau",R.mipmap.ic_launcher);
        HashPoisson.put("Merlu",R.mipmap.ic_launcher);
        HashPoisson.put("Moules",R.mipmap.ic_launcher);
        HashPoisson.put("Oeufs de lump",R.mipmap.ic_launcher);
        HashPoisson.put("Saint Jacques",R.mipmap.ic_launcher);
        HashPoisson.put("Sardines",R.mipmap.ic_launcher);
        HashPoisson.put("Saumon",R.mipmap.ic_launcher);
        HashPoisson.put("Saumon fumé",R.mipmap.ic_launcher);
        HashPoisson.put("Sole",R.mipmap.ic_launcher);
        HashPoisson.put("Surimi",R.mipmap.ic_launcher);
        HashPoisson.put("Thon en boite",R.mipmap.ic_launcher);
        HashPoisson.put("Truite",R.mipmap.ic_launcher);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        lv = (GridView) findViewById(R.id.ListViewAliment);
        arrayListAliments = ListeAliment.alimentsArraylist(HashPoisson);
        lv.setAdapter(new Adapter(arrayListAliments,context));
    }


}
