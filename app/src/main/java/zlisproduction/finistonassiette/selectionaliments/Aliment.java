package zlisproduction.finistonassiette.selectionaliments;

import android.content.Context;

import java.util.HashMap;

import zlisproduction.finistonassiette.R;

/**
 * Created by Florian.S on 05/06/2015.
 *
 * Cette classe stockera 2 HashMap, la première permettra d'accéder à la catégorie
 * La seconde contenue dans la première stockera tout les aliments et leur image associées
 */
public class Aliment {

    // HashMap pour trouver la HashMap aliment selon la catégorie
    private HashMap<String,HashMap<String,Integer>> hashMapCatégories = new HashMap<>();

    // Toutes les hashmap pour chaque catégorie
    private HashMap <String, Integer> hashMapCereales= new HashMap <>();

    public Aliment(Context pContext){
        CreateListeAliments(pContext);
    }

    public void CreateListeAliments(Context pContext){
        hashMapCatégories.put(pContext.getString(R.string.Céréales),hashMapCereales);

        // Céréales
        hashMapCereales.put(pContext.getString(R.string.Blé), R.drawable.ic_beurretransparent);
        hashMapCereales.put(pContext.getString(R.string.Boulghour), R.drawable.ic_boulgourtransparentlast);
        hashMapCereales.put(pContext.getString(R.string.Farine_de_froment), R.drawable.ic_farine_fromenttransparent);
        hashMapCereales.put(pContext.getString(R.string.Lasagnes), R.drawable.ic_beurretransparent);
        hashMapCereales.put(pContext.getString(R.string.Müesli), R.drawable.ic_beurretransparent);
        hashMapCereales.put(pContext.getString(R.string.Pâtes_de_riz), R.drawable.ic_beurretransparent);
        hashMapCereales.put(pContext.getString(R.string.Quinoa), R.drawable.ic_beurretransparent);
        hashMapCereales.put(pContext.getString(R.string.Riz_complet), R.drawable.ic_rizcomplettransparent);
        hashMapCereales.put(pContext.getString(R.string.Sarrasin), R.drawable.ic_beurretransparent);

    }

    public HashMap<String, Integer> getHashMapAlimentFromCategorie(String pCategorie) {
        return hashMapCatégories.get(pCategorie);
    }

}

