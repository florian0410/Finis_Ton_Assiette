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
public class Farine extends AppCompatActivity{

    private HashMap<String,Integer> hashMapFarine = new HashMap<String,Integer>();
    private ArrayList<Aliment> arrayListAliments;
    private GridView lv;
    private Context context=Farine.this;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        /*
        Construction de la HashMap hashMapFarine
         */
        hashMapFarine.put(getString(R.string.Farine_de_blé), R.mipmap.ic_launcher);
        lv = (GridView) findViewById(R.id.ListViewAliment);
        arrayListAliments = ListeAliment.alimentsArraylist(hashMapFarine);
        lv.setAdapter(new Adapter(arrayListAliments,context));
    }
}
