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
public class Fruit extends AppCompatActivity {

    private HashMap<String, Integer> hashMapFruit= new  HashMap<String, Integer>();
    // image associï¿½e aux aliments : j'utilise une icï¿½ne psk j'ai rien d'autre pour l'instant et c'est la mï¿½me pour tous les produits

    private ArrayList<Aliment> arrayListAliments;
    private GridView lv;
    private Context context=Fruit.this;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        lv = (GridView) findViewById(R.id.ListViewAliment);
        /*
        Création de la Hashmap hashMapFruit
         */

        hashMapFruit.put("abricots", R.mipmap.ic_launcher);
        hashMapFruit.put("amandes", R.mipmap.ic_launcher);
        hashMapFruit.put("ananas", R.mipmap.ic_launcher);
        hashMapFruit.put("banane", R.mipmap.ic_launcher);
        hashMapFruit.put("cassis", R.mipmap.ic_launcher);
        hashMapFruit.put("cerises", R.mipmap.ic_launcher);
        hashMapFruit.put("châtaignes", R.mipmap.ic_launcher);
        hashMapFruit.put("citron(s)", R.mipmap.ic_launcher);
        hashMapFruit.put("citron vert", R.mipmap.ic_launcher);
        hashMapFruit.put("clémentine", R.mipmap.ic_launcher);
        hashMapFruit.put("coing", R.mipmap.ic_launcher);
        hashMapFruit.put("dattes", R.mipmap.ic_launcher);
        hashMapFruit.put("figues", R.mipmap.ic_launcher);
        hashMapFruit.put("fraises", R.mipmap.ic_launcher);
        hashMapFruit.put( "framboises", R.mipmap.ic_launcher);
        hashMapFruit.put("fruit de la passion", R.mipmap.ic_launcher);
        hashMapFruit.put("fruits confits",R.mipmap.ic_launcher);
        hashMapFruit.put("goyave",R.mipmap.ic_launcher);
        hashMapFruit.put("groseilles",R.mipmap.ic_launcher);
        hashMapFruit.put("kiwi",R.mipmap.ic_launcher);
        hashMapFruit.put("litchies",R.mipmap.ic_launcher);
        hashMapFruit.put("mangue",R.mipmap.ic_launcher);
        hashMapFruit.put("melon",R.mipmap.ic_launcher);
        hashMapFruit.put("mirabelles",R.mipmap.ic_launcher);
        hashMapFruit.put("myrtilles",R.mipmap.ic_launcher);
        hashMapFruit.put("noisettes",R.mipmap.ic_launcher);
        hashMapFruit.put("orange",R.mipmap.ic_launcher);
        hashMapFruit.put("pamplemousse",R.mipmap.ic_launcher);
        hashMapFruit.put("papaye",R.mipmap.ic_launcher);
        hashMapFruit.put("pêche",R.mipmap.ic_launcher);
        hashMapFruit.put("pastèque",R.mipmap.ic_launcher);
        hashMapFruit.put("pistaches",R.mipmap.ic_launcher);
        hashMapFruit.put("poire",R.mipmap.ic_launcher);
        hashMapFruit.put("pomme",R.mipmap.ic_launcher);
        hashMapFruit.put("prunes",R.mipmap.ic_launcher);
        hashMapFruit.put("raisin blanc",R.mipmap.ic_launcher);
        hashMapFruit.put("raisin noir",R.mipmap.ic_launcher);
        hashMapFruit.put( "rhubarbe",R.mipmap.ic_launcher);

        arrayListAliments = ListeAliment.alimentsArraylist(hashMapFruit);
        lv.setAdapter(new Adapter(arrayListAliments,context));
    }
}
