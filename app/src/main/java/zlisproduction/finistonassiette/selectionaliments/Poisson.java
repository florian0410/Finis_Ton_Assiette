package zlisproduction.finistonassiette.selectionaliments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import zlisproduction.finistonassiette.R;

/**
 * Created by Florian on 15/05/2015.
 */
public class Poisson extends Activity {

    private final  HashMap<String, Integer> HashPoisson = new HashMap<String, Integer>();
    private ArrayList<Aliment> arrayListAliments;
    private GridView lv;
    private Context context=Poisson.this;
    private List<String> result;



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
        result= new ArrayList<String>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        lv = (GridView) findViewById(R.id.ListViewAliment);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Aliment alim = arrayListAliments.get(position);
                if (alim.isClicked() == false) {
                    //Si l'aliment n'est pas coché on le met dans la liste des résultats et on le met coché
                    alim.setIsClicked(true);
                    //ajout de l'aliment à la liste si il n'existe pas déja dedans

                    result.add(alim.getName());
                } else {
                    alim.setIsClicked(true);
                    result.remove(alim.getName());
                }

            }
        });
        arrayListAliments = ListeAliment.alimentsArraylist(HashPoisson);
        lv.setAdapter(new Adapter(arrayListAliments,context));
    }


}
