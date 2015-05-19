package zlisproduction.finistonassiette.selectionaliments;

import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Thibaut on 19/05/2015.
 */
public  class Result {

    private static ArrayList<String> alimentsSelectionnes = new ArrayList<String>();
    private static boolean doublons=false;

    public static void setAlimentsSelectionnes (String pAlimentsSelectionnes) {

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
            Result.alimentsSelectionnes.add(pAlimentsSelectionnes);
        }

    }

    public static void deleteAliment (String pAlimentsSelectionnes){
        Result.alimentsSelectionnes.remove(pAlimentsSelectionnes);
    }
}
