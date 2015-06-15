package zlisproduction.finistonassiette.recette;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Thibaut on 24/05/2015.
 */
public interface AnalyseResultat {

    /**
    Retourne la liste de toutes les recettes possédant les aliments critiques

     */
    public ArrayList<HashMap<String, Object>> demande_consulter_recette() throws JSONException;

    public void resutat_ajouter_recette();
    public void resultat_suggestion_courses();
    public HashMap<String,String> getCompteAttributes();


}
