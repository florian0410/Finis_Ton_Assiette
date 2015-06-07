package zlisproduction.finistonassiette.recette;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Thibaut on 24/05/2015.
 */
public class JsonFormat implements AnalyseResultat {
    private String[] data= null;
    ArrayList<HashMap<String, String>> arrayList= null;

    public JsonFormat(String[] pData){

        this.data=pData;
        arrayList= new ArrayList<HashMap<String, String>>();

    }


    @Override
    public ArrayList<HashMap<String, String>> demande_consulter_recette() throws JSONException {

        int nombre_recettes_trouvees =data.length;
        HashMap<String,String> map = new HashMap<String, String>();
        JSONObject jsonObject=null;
        int i ;
        for(i=0; i<nombre_recettes_trouvees;i++){
            try {
                jsonObject= new JSONObject(data[i]);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //récupération des caractéristiques de la recette
            map.put("nom_recette_creee",jsonObject.getString("nom_recette_creee"));
            map.put("type_plat",jsonObject.getString("type_plat"));
            map.put("niveau_difficulte",jsonObject.getString("niveau_difficulte"));
            map.put("ingredient",jsonObject.getString("ingredient"));
            map.put("temps_cuisson",jsonObject.getString("temps_cuisson"));
            map.put("temps_preparation",jsonObject.getString("temps_preparation"));
            map.put("preparation_recette",jsonObject.getString("preparation_recette"));
            map.put("auteur_recette",jsonObject.getString("auteur_recette"));
            //récupération des data de l'image
            //mettre une exception ici
            if((i+1)<nombre_recettes_trouvees) {
                map.put("image", data[i + 1]);
            }
            i++;
            arrayList.add(map);
        }

        return arrayList;
        //http://www.tutomobile.fr/personnaliser-une-listview-tutoriel-android-n%C2%B07/04/07/2010/
        //http://stackoverflow.com/questions/19660170/how-to-display-image-in-imageview-from-byte-bitmapfactory-decodebytearray-ret ddfdfddf
    }

    @Override
    public void resutat_ajouter_recette() {

    }

    @Override
    public void resultat_suggestion_courses() {

    }
}
