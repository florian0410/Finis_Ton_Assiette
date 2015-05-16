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
public class Legume extends AppCompatActivity {

    private HashMap<String, Integer> hashMapLegumes= new HashMap<String, Integer>();
    private ArrayList<Aliment> arrayListAliments;
    private GridView lv;
    private Context context=Legume.this;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        lv = (GridView) findViewById(R.id.ListViewAliment);
        /*
        Création de la Hashmap hashMapLegumes
         */

        hashMapLegumes.put("artichaut(s)", R.mipmap.ic_launcher);
        hashMapLegumes.put("aubergine(s)", R.mipmap.ic_launcher);
        hashMapLegumes.put("avocat(s)", R.mipmap.ic_launcher);
        hashMapLegumes.put("betterave(s)", R.mipmap.ic_launcher);
        hashMapLegumes.put("broccoli(s)", R.mipmap.ic_launcher);
        hashMapLegumes.put("carotte(s)", R.mipmap.ic_launcher);
        hashMapLegumes.put("chou (blanc ou vert)", R.mipmap.ic_launcher);
        hashMapLegumes.put("chou-fleur", R.mipmap.ic_launcher);
        hashMapLegumes.put("choux de Bruxelles", R.mipmap.ic_launcher);
        hashMapLegumes.put("coeur(s) de palmier", R.mipmap.ic_launcher);
        hashMapLegumes.put("concombre(s)", R.mipmap.ic_launcher);
        hashMapLegumes.put("courgette(s)", R.mipmap.ic_launcher);
        hashMapLegumes.put("épinards", R.mipmap.ic_launcher);
        hashMapLegumes.put("fenouil", R.mipmap.ic_launcher);
        hashMapLegumes.put("flageolets", R.mipmap.ic_launcher);
        hashMapLegumes.put("germes de soja", R.mipmap.ic_launcher);
        hashMapLegumes.put("haricots verts", R.mipmap.ic_launcher);
        hashMapLegumes.put("lentilles", R.mipmap.ic_launcher);
        hashMapLegumes.put("maïs", R.mipmap.ic_launcher);
        hashMapLegumes.put("navet(s)", R.mipmap.ic_launcher);
        hashMapLegumes.put("olives noires", R.mipmap.ic_launcher);
        hashMapLegumes.put("olives vertes", R.mipmap.ic_launcher);
        hashMapLegumes.put("patate(s) douce(s)", R.mipmap.ic_launcher);
        hashMapLegumes.put("petits pois", R.mipmap.ic_launcher);
        hashMapLegumes.put("poireau(x)", R.mipmap.ic_launcher);
        hashMapLegumes.put("pois cassés", R.mipmap.ic_launcher);
        hashMapLegumes.put("pois chiches", R.mipmap.ic_launcher);
        hashMapLegumes.put("pois gourmands", R.mipmap.ic_launcher);
        hashMapLegumes.put("poivron(s)", R.mipmap.ic_launcher);
        hashMapLegumes.put("potimarron", R.mipmap.ic_launcher);
        hashMapLegumes.put("potiron", R.mipmap.ic_launcher);
        hashMapLegumes.put("radis", R.mipmap.ic_launcher);
        hashMapLegumes.put("salade verte", R.mipmap.ic_launcher);
        hashMapLegumes.put("tomate(s) verte(s)", R.mipmap.ic_launcher);

        arrayListAliments = ListeAliment.alimentsArraylist(hashMapLegumes);
        lv.setAdapter(new Adapter(arrayListAliments,context));
    }


}
