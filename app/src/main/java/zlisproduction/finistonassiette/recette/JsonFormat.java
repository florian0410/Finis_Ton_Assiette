package zlisproduction.finistonassiette.recette;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Thibaut on 24/05/2015.
 */
public class JsonFormat implements AnalyseResultat {

    private String json;
    private JSONObject objet_json;

    public JsonFormat(String pString) {
        this.json=pString;
        analyse_donnees_reponse_consulter_recette(pString);
    }

    @Override
    public JSONObject analyse_donnees_reponse_consulter_recette( String pData) {

        try {
            objet_json= new JSONObject(pData);
            return  objet_json;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
