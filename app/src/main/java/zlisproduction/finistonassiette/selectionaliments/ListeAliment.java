package zlisproduction.finistonassiette.selectionaliments;

import java.util.ArrayList;

/**
 * Created by Thibaut on 15/05/2015.
 * retourne un ArrayList contenant les objets Aliments
 */
public class ListeAliment {

    private static ArrayList<Aliment> aliments;

    /**
     *  retourne un ArrayList contenant les objets Aliments
     * @param pListeAliments
     * @param pImage
     * @return ArrayList <Aliment>
     */
public static ArrayList <Aliment>  alimentsArraylist (String[] pListeAliments, int[] pImage)
    {
        int size=pListeAliments.length;
        for (int i=0; i<size; i++){
            Aliment alim = new Aliment(pImage[i],pListeAliments[i]);
            aliments.add(alim);
        }
        return aliments;
    }


}
