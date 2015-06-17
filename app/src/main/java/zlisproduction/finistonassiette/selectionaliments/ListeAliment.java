package zlisproduction.finistonassiette.selectionaliments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Thibaut on 15/05/2015.
 * retourne un ArrayList contenant les objets Aliments
 */
public class ListeAliment {



    private static ArrayList<AlimentDisplayer>  aliments = new ArrayList<AlimentDisplayer>();

    /**
     *  Création des objets aliments et stockage dans un ArrayList
     * @param pListeAliments
     * @return ArrayList <Aliment>
     */
public static ArrayList <AlimentDisplayer>  alimentsArraylist (HashMap<String, Integer> pListeAliments)
    {
        aliments.clear();
        Iterator<String> keySetIterator = pListeAliments.keySet().iterator();

        while(keySetIterator.hasNext()){
            String key = keySetIterator.next();
            AlimentDisplayer alim = new AlimentDisplayer(pListeAliments.get(key),key);
            aliments.add(alim);
        }
        return aliments;
    }


}
