package zlisproduction.finistonassiette.selectionaliments;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;
import zlisproduction.finistonassiette.R;

/**
 * Created by Florian on 15/05/2015.
 */
public class Poisson extends AppCompatActivity{
    private  final String[] nomAliments = {"cabillaud",
            "calamars",
            "colin",
            "crevettes",
            "daurade",
            "fletan",
            "gambas",
            "haddock",
            "hareng",
            "lieu",
            "maquereau",
            "merlu",
            "moules",
            "oeufs de lump",
            "Saint Jacques",
            "sardines",
            "saumon",
            "saumon fume",
            "sole",
            "surimi",
            "thon en boite",
            "truite"};

    // image associ�e aux aliments : j'utilise une ic�ne psk j'ai rien d'autre pour l'instant et c'est la m�me pour tous les produits
    private int imageAliment= R.mipmap.ic_launcher;
    private ArrayList<Aliment> arrayListAliments;
    private GridView lv;
    private Context context=Poisson.this;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        lv = (GridView) findViewById(R.id.ListViewAliment);
        arrayListAliments = Aliment.alimentsArraylist(nomAliments);
        lv.setAdapter(new Adapter(arrayListAliments,context));
    }


}
