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
public class Cereale extends AppCompatActivity {
    private  final String[] nomAliments = {"blé",
            "boulghour",
            "farine de froment",
            "lasagnes",
            "milmüesli",
            "pâtes de riz",
            "quinoa",
            "riz complet",
            "sarrazin",
    };

    // image associï¿½e aux aliments : j'utilise une icï¿½ne psk j'ai rien d'autre pour l'instant et c'est la mï¿½me pour tous les produits
    private final int[] imageAliment= {R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
    };
    private ArrayList<Aliment> arrayListAliments;
    private GridView lv;
    private Context context=Cereale.this;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        lv = (GridView) findViewById(R.id.ListViewAliment);
        arrayListAliments = ListeAliment.alimentsArraylist(nomAliments,imageAliment);
        lv.setAdapter(new Adapter(arrayListAliments,context));
    }

}
