package zlisproduction.finistonassiette.recette;

import org.json.JSONObject;

/**
 * Created by Thibaut on 24/05/2015.
 */
public interface AnalyseResultat {

    public JSONObject analyse_donnees_reponse_consulter_recette( String pData);
}
