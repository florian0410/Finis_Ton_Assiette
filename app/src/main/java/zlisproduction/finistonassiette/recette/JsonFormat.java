package zlisproduction.finistonassiette.recette;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Created by Thibaut on 24/05/2015.
 */
public class JsonFormat implements AnalyseResultat {
    private String[] data= null;
    ArrayList<HashMap<String, Object>> arrayList= null;

    public JsonFormat(String[] pData){

        this.data=pData;
        arrayList= new ArrayList<HashMap<String, Object>>();

    }


    @Override
    public ArrayList<HashMap<String, Object>> demande_consulter_recette() throws JSONException {

        int nombre_recettes_trouvees =data.length;

        HashMap<String,Object> map = null;

        JSONObject jsonObject=null;

        int i=0;
        while(i<nombre_recettes_trouvees){

            map= new HashMap<>();
            //si c'est la fin de la recupération
            if(!data[i].equals("\n")) {

                try {
                    jsonObject = new JSONObject(data[i]);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //récupération des caractéristiques de la recette
                map.put("nom_recette_creee", jsonObject.getString("nom_recette_creee").replaceAll("_", " "));

                map.put("type_plat", jsonObject.getString("type_plat"));

                map.put("niveau_difficulte", jsonObject.getString("niveau_difficulte"));

                //constitution d'un tableau de string (tableau d'ingrédient)
                String[] tmp = jsonObject.getString("ingredient").replaceAll("\\[\\{\"","").replaceAll("\"\\}\\]","").replaceAll("nom_ingredient\":","").replaceAll("\"","").replaceAll("\\{","").replaceAll("\\}","").split("\\,");
                map.put("ingredient", tmp);

                map.put("temps_cuisson", jsonObject.getString("temps_cuisson"));

                map.put("temps_preparation", jsonObject.getString("temps_preparation"));

                tmp= jsonObject.getString("preparation_recette").split("\"\\},\\{\"");

                for (int v =0; v<tmp.length; v++)
                {
                    tmp[v]= tmp[v].replaceAll("\"","").replaceAll("\\[\\{","").replaceAll("\\}\\]","");
                }
                map.put("preparation_recette", tmp);

                map.put("auteur_recette", jsonObject.getString("auteur_recette"));
                //récupération des data de l'image
                //mettre une exception ici
                i++;
                if (i < nombre_recettes_trouvees) {

                    String tmpData= data[i];
                    map.put("image", tmpData);
                }

                i++;
                arrayList.add(map);
            }
            else{
                i++;
            }

        }

        return arrayList;

    }

    @Override
    public void resutat_ajouter_recette() {

    }

    @Override
    public void resultat_suggestion_courses() {

    }

    @Override
    public HashMap<String, String> getCompteAttributes() {
        return null;
    }
}
