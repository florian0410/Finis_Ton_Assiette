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
public class Fruit extends Activity {

    private HashMap<String, Integer> hashMapFruit= new  HashMap<String, Integer>();
    // image associï¿½e aux aliments : j'utilise une icï¿½ne psk j'ai rien d'autre pour l'instant et c'est la mï¿½me pour tous les produits

    private ArrayList<Aliment> arrayListAliments;
    private GridView lv;
    private Context context=Fruit.this;
    private Button boutonfin;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        boutonfin=(Button)findViewById(R.id.finselection);
        boutonfin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        lv = (GridView) findViewById(R.id.ListViewAliment);
        /*
        Création de la Hashmap hashMapFruit
         */

        hashMapFruit.put(getString(R.string.Abricots), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Amandes), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Ananas), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Banane), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Cassis), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Cerises), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Châtaignes), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Citron), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Citron_vert), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Clémentine), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Coing), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Dattes), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Figues), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Fraises), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Framboises), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Fruit_de_la_passion), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Fruits_confits), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Goyave), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Groseilles), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Kiwi), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Litchies), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Mangue), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Melon), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Mirabelles), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Myrtilles), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Noisettes), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Orange), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Pamplemousse), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Papaye), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Pêche), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Pastèque), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Pistaches), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Poire), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Pomme), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Prunes), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Raisin_blanc), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Raisin_noir), R.drawable.ic_beurretransparent);
        hashMapFruit.put(getString(R.string.Rhubarde), R.drawable.ic_beurretransparent);

        arrayListAliments = ListeAliment.alimentsArraylist(hashMapFruit);
        lv.setAdapter(new Adapter(arrayListAliments,context));
    }
}
