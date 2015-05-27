package zlisproduction.finistonassiette.selectionaliments;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

import zlisproduction.finistonassiette.R;

/**
 * Created by Thibaut on 19/05/2015.
 */
public class CreateListAliment {

    private static ArrayList<String> alimentsSelectionnes = new ArrayList<String>();
    private static boolean doublons=false;

    public static boolean addAlimentSelectionne(String pAlimentsSelectionnes) {

        /*
        éliminer les doublons
         */
        Iterator<String> it =alimentsSelectionnes.iterator();
        while (it.hasNext()) {
           if(it.next()==pAlimentsSelectionnes){
               doublons=true;
           }
        }
        if (doublons==false) {
            alimentsSelectionnes.add(pAlimentsSelectionnes);
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
        for(int i = 0; i< alimentsSelectionnes.size();i++){
            alimName = alimentsSelectionnes.get(i);
            listAlim += alimName+" ";
        }
        Toast.makeText(pContext,listAlim, Toast.LENGTH_LONG).show();
        cleanAlimList(pContext);
    }

    /*
     * Méthode pour vider la liste des aliments stockés
     */
    public static void cleanAlimList(Context pContext){
       alimentsSelectionnes.clear();
        Toast.makeText(pContext,pContext.getString(R.string.liste_aliments_remise_à_zéro), Toast.LENGTH_SHORT).show();
    }
}
