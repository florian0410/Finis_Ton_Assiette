package zlisproduction.finistonassiette.selectionaliments;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import zlisproduction.finistonassiette.R;

/**
 * Created by Thibaut on 19/05/2015.
 */
public class CreateListAliment {

    private static HashMap<String,Integer> alimentsSelectionnes = new HashMap<>();
    private static boolean doublons=false;
    private static  Set key= null;

    public static boolean addAlimentSelectionne(String pAlimentsSelectionnes, int pImage) {
        key = alimentsSelectionnes.keySet();
        /*
        éliminer les doublons
         */
        Iterator<String> it =key.iterator();
        while (it.hasNext()) {
           if(it.next()==pAlimentsSelectionnes){
               doublons=true;
           }
        }
        if (doublons==false) {
            alimentsSelectionnes.put(pAlimentsSelectionnes, pImage);
        }
        return doublons;
    }

    public static void deleteAliment (String pAlimentsSelectionnes){
        CreateListAliment.alimentsSelectionnes.remove(pAlimentsSelectionnes);
    }

    /*
     *Méthode pour renvoyer la liste des aliments
     */
    public static void getAlimList(Context pContext){
        String alimName =null;
        String listAlim = pContext.getString(R.string.Liste_des_aliments);
        for(String mapkey : alimentsSelectionnes.keySet()){
            alimName = mapkey;
            listAlim += alimName+" ";
        }
        Toast.makeText(pContext,listAlim, Toast.LENGTH_LONG).show();
        //cleanAlimList(pContext);
    }

    public static HashMap<String,Integer> getAlimentSelectionnes(){
        return alimentsSelectionnes;
    }
    /*
     * Méthode pour vider la liste des aliments stockés
     */
    public static void cleanAlimList(Context pContext){
       alimentsSelectionnes.clear();
        Toast.makeText(pContext,pContext.getString(R.string.liste_aliments_remise_à_zéro), Toast.LENGTH_SHORT).show();
    }

    public static HashMap<String,Integer> getAlimentsSelectionnes() {
        return alimentsSelectionnes;
    }


    public static ArrayList<String> HashMapToArrayList(){

        ArrayList<String> array= new ArrayList<String>();

        for(String mapkey : alimentsSelectionnes.keySet()){
            array.add(mapkey);
        }
    return array;
    }

}
