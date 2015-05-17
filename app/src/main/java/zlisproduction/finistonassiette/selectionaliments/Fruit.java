package zlisproduction.finistonassiette.selectionaliments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        hashMapFruit.put(getString(R.string.Abricots), R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Amandes), R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Ananas), R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Banane), R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Cassis), R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Cerises), R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Châtaignes), R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Citron), R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Citron_vert), R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Clémentine), R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Coing), R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Dattes), R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Figues), R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Fraises), R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Framboises), R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Fruit_de_la_passion), R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Fruits_confits),R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Goyave),R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Groseilles),R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Kiwi),R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Litchies),R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Mangue),R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Melon),R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Mirabelles),R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Myrtilles),R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Noisettes),R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Orange),R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Pamplemousse),R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Papaye),R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Pêche),R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Pastèque),R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Pistaches),R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Poire),R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Pomme),R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Prunes),R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Raisin_blanc),R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Raisin_noir),R.mipmap.ic_launcher);
        hashMapFruit.put(getString(R.string.Rhubarde),R.mipmap.ic_launcher);

        arrayListAliments = ListeAliment.alimentsArraylist(hashMapFruit);
        lv.setAdapter(new Adapter(arrayListAliments,context));
    }
}
