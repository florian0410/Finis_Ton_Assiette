package zlisproduction.finistonassiette.selectionaliments;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import zlisproduction.finistonassiette.R;

/**
 * Created by Thibaut on 16/05/2015.
 */
public class Pates extends Activity {

    private final HashMap<String, Integer> hashMapPates = new HashMap<String, Integer>();
    private ArrayList<Aliment> arrayListAliments;
    private GridView lv;
    private Context context=Pates.this;
    private List <String> result;



    protected void onCreate(Bundle savedInstanceState){

        // Remplissage de la HashMap associant le nom de l'aliment (clé) et son image (objet renvoyé par clé)
        hashMapPates.put(getString(R.string.Coquillettes), R.drawable.ic_beurretransparent);
        hashMapPates.put(getString(R.string.Spaghetti), R.drawable.ic_beurretransparent);
        hashMapPates.put(getString(R.string.Farfalle), R.drawable.ic_beurretransparent);
        hashMapPates.put(getString(R.string.Penne_Rigate), R.drawable.ic_beurretransparent);
        hashMapPates.put(getString(R.string.Linguine), R.drawable.ic_beurretransparent);
        hashMapPates.put(getString(R.string.Tagliatelle), R.drawable.ic_beurretransparent);
        hashMapPates.put(getString(R.string.Macaroni), R.drawable.ic_beurretransparent);
        hashMapPates.put(getString(R.string.Nouilles), R.drawable.ic_beurretransparent);
        hashMapPates.put(getString(R.string.Fusilli), R.drawable.ic_beurretransparent);
        hashMapPates.put(getString(R.string.Capellini), R.drawable.ic_beurretransparent);
        hashMapPates.put(getString(R.string.Torti), R.drawable.ic_beurretransparent);
        hashMapPates.put(getString(R.string.Vermicelli), R.drawable.ic_beurretransparent);
        hashMapPates.put(getString(R.string.Lasagnes), R.drawable.ic_beurretransparent);
        result= new ArrayList<String>();


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
                }
                else {
                    alim.setIsClicked(true);
                    result.remove(alim.getName());
                }

            }
        });
        arrayListAliments = ListeAliment.alimentsArraylist(hashMapPates);
        lv.setAdapter(new Adapter(arrayListAliments,context));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent= new Intent();//tableau de string
        String[] stockArr = new String[result.size()];
        stockArr = result.toArray(stockArr);

        intent.putExtra(PatesFarinesCereales.RESULT_PATES,stockArr);
        setResult(RESULT_OK,intent);
        finish();
    }





}
