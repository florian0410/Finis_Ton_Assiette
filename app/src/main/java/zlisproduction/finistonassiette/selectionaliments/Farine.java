package zlisproduction.finistonassiette.selectionaliments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
public class Farine extends Activity {

    private HashMap<String,Integer> hashMapFarine = new HashMap<String,Integer>();
    private ArrayList<Aliment> arrayListAliments;
    private GridView lv;
    private List<String> result;
    private Context context=Farine.this;



    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        /*
        Construction de la HashMap hashMapFarine
         */
        hashMapFarine.put(getString(R.string.Farine_de_blé), R.drawable.ic_beurretransparent);
        result=new ArrayList<String>();

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
        arrayListAliments = ListeAliment.alimentsArraylist(hashMapFarine);
        lv.setAdapter(new Adapter(arrayListAliments, context));
    }
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent= new Intent();//tableau de string
        String[] stockArr = new String[result.size()];
        stockArr = result.toArray(stockArr);

        intent.putExtra(PatesFarinesCereales.RESULT_FARINES, stockArr);
        setResult(RESULT_OK,intent);
        finish();
    }
}
