package zlisproduction.finistonassiette.recette;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Thibaut on 13/06/2015.
 */
public class JsonFormatConsultationCompte implements AnalyseResultat {
    String[] data =null;

    public JsonFormatConsultationCompte(String ptab[]){
        data= ptab;

    }

    public HashMap<String,String> getCompteAttributes(){

        HashMap<String,String> map = new HashMap<String,String>();
        try {

            JSONObject jsonObject= new JSONObject(data[0]);



            map.put("pseudo",jsonObject.get("pseudo").toString());
            map.put("mot_de_passe",jsonObject.get("mot_de_passe").toString());
            map.put("adresse_mail",jsonObject.get("adresse_mail").toString());
            map.put("utilisateur_consultation",jsonObject.get("utilisateur_consultation").toString());
            map.put("recette_consultation",jsonObject.get("recette_consultation").toString());
            map.put("date_consultation",jsonObject.get("date_consultation").toString());
            map.put("recette_creee",jsonObject.get("recette_creee").toString());
            map.put("date_creation",jsonObject.get("date_creation").toString());


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public ArrayList<HashMap<String, Object>> demande_consulter_recette() throws JSONException {
        return null;
    }

    @Override
    public void resutat_ajouter_recette() {

    }

    @Override
    public void resultat_suggestion_courses() {

    }
}
