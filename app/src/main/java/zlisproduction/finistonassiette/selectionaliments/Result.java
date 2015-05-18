package zlisproduction.finistonassiette.selectionaliments;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Thibaut on 19/05/2015.
 */
public  class Result {
    private static ArrayList<String> alimentsSelectionnes = new ArrayList<String>();

    public static void setAlimentsSelectionnes (String alimentsSelectionnes) {

        Result.alimentsSelectionnes.add(alimentsSelectionnes);
        String  a=Integer.toString(alimentsSelectionnes.length());
        Log.i("dsfsq",a);
    }
}
