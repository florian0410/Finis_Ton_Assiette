package zlisproduction.finistonassiette.recette;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Thibaut on 24/05/2015.
 */
public class JsonFormat implements AnalyseResultat {
    private String[] data= null;

    public JsonFormat(String[] pData){
        this.data=pData;

    }


    @Override
    public void demande_consulter_recette() {


    }

    @Override
    public void resutat_ajouter_recette() {

    }

    @Override
    public void resultat_suggestion_courses() {

    }
}
