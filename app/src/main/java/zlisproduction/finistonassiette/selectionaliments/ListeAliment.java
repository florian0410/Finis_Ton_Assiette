package zlisproduction.finistonassiette.selectionaliments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Thibaut on 15/05/2015.
 * retourne un ArrayList contenant les objets Aliments
 */
public class ListeAliment {


    private static HashMap<String,Integer> objetsAliments;
    private static ArrayList<Aliment> aliments;

    public static HashMap<String,Integer> tableToHashMap(){
        objetsAliments.put("avion",5)
    }
    /**
     *  Création des objets aliments et stockage dans un ArrayList
     * @param pListeAliments
     * @return ArrayList <Aliment>
     */
public static ArrayList <Aliment>  alimentsArraylist (HashMap<String, Integer> pListeAliments)
    {
       /* int size=pListeAliments.size();
        for (int i=0; i<size; i++){
            Aliment alim = new Aliment(pListeAliments.,pListeAliments[i]);
            aliments.add(alim);
        }
        return aliments;
            */
        Iterator<String> keySetIterator = pListeAliments.keySet().iterator();

        while(keySetIterator.hasNext()){
            String key = keySetIterator.next();
            Aliment alim = new Aliment(pListeAliments.get(key),key);
            aliments.add(alim);
        }
        return aliments;
    }


}
