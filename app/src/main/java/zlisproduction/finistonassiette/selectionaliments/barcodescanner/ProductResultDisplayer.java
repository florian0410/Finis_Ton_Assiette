package zlisproduction.finistonassiette.selectionaliments.barcodescanner;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import zlisproduction.finistonassiette.R;
import zlisproduction.finistonassiette.adapter.Adapter;
import zlisproduction.finistonassiette.selectionaliments.Aliment;
import zlisproduction.finistonassiette.selectionaliments.AlimentDisplayer;
import zlisproduction.finistonassiette.selectionaliments.AlimentListDisplayer;
import zlisproduction.finistonassiette.selectionaliments.CreateListAliment;
import zlisproduction.finistonassiette.selectionaliments.ListeAliment;
import zlisproduction.finistonassiette.selectionaliments.MenuPrincipal;

/**
 * Created by Florian.S on 05/06/2015.
 * Cette classe sera affichée sur une même page que le produit scanné par l'utilisateur lors de l'utilisation du scanner
 */
public class ProductResultDisplayer extends AlimentListDisplayer {

    private TextView mTitle = null;
    private TextView mCategories = null;
    private Context context = null;
    private String mScanContent = null;
    private GridView lv;
    private Button boutonfin = null;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = activity.getApplicationContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View Layout = null;
        HashMap<String, Integer> results = getResults();
        if(results != null && results.size() != 0) {

        Layout = inflater.inflate(R.layout.listview, container, false);

        lv = (GridView) Layout.findViewById(R.id.ListViewAliment);
        boutonfin=(Button) Layout.findViewById(R.id.boutonfinselection);


            arrayListAlimentsDisplayer = ListeAliment.alimentsArraylist(results);

            myAdapter = new Adapter(arrayListAlimentsDisplayer, context);
            lv.setAdapter(myAdapter);

            // Listener pour sélection des aliments
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    AlimentDisplayer alim = arrayListAlimentsDisplayer.get(position);
                    if (alim.isClicked() == false) {
                        CheckItem(alim, myAdapter);
                    } else {
                        unCheckItem(alim, myAdapter);
                    }
                }
            });
            //Listener permettant l'envoi des aliments choisis à l'appui du bouton
            boutonfin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CreateListAliment.getAlimList(context);
                    // Retour au menu principal
                    // Plus tard ce sera affichage de la liste des résultats
                    Fragment fragment = new MenuPrincipal();
                    ChangeFragment(v, fragment);
                }
            });
        }
        else{
            Layout = inflater.inflate(R.layout.text_error, container, false);
            TextView errorMsg = (TextView) Layout.findViewById(R.id.textError);
            errorMsg.setText("Produit non reconnu ou non existant parmis nos aliments, n'hésitez pas à essayer la recherche manuelle des aliments");
        }
        return Layout;
    }

    public HashMap<String, Integer> getResults(){
        Bundle bundle = new Bundle();
        bundle = this.getArguments();
        String ProductDatas = bundle.getString("Product");
        String[] keywords = getKeyWordsFromJSON(ProductDatas);
        if (keywords != null) {
            Aliment alim = new Aliment(context);
            HashMap<String, Integer> results = alim.TrouverAliment(keywords);
            return results;
        }
        return null;
    }

    protected String[] getKeyWordsFromJSON(String pDatasProduct) {
        String KeyWords[] = null;
        try {
            JSONObject json = new JSONObject(pDatasProduct);
            // Getting JSON Array
            // name = json.getJSONArray("contacts");   // Quand démarre par [
            // Exception utilse quand page web non JSON ou pas de connectivité malgrés wifi
            int status = json.getInt("status");

            // Check detection produit
            if (status != 0) {
                JSONObject c = json.getJSONObject("product");   // quand démarre par { ou quand une seule case

                // Check si le produit est incomplet au niveau infos
                String creator = c.getString("creator");
                if (creator != "null") {
                    // String categories = c.getString("categories");
                    JSONArray KeyWordsJson = c.getJSONArray("_keywords");
                    KeyWords = new String[KeyWordsJson.length()];
                    for (int i = 0; i < KeyWords.length; i++) {
                        KeyWords[i] = KeyWordsJson.getString(i);
                    }
                } else {
                    return null;
                }
            }
            else return null;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return KeyWords;
    }
}
