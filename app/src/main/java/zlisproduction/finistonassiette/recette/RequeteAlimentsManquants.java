package zlisproduction.finistonassiette.recette;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by Thibaut on 14/06/2015.
 */
public class RequeteAlimentsManquants extends Requete {
    @Override
    public void envoyerRequete(ArrayList pData) {

    }

    @Override
    protected String[] doInBackground(ArrayList<String>... params) {

        int nombre_aliments_possedes= params[0].size();
        StringBuilder url = new StringBuilder("http://finistonassiette.ddns.net/requetephp/listecourse/listecourse.php?");
        //Construction de l'url
        for (int i= 0; i<nombre_aliments_possedes-1; i++){
            url.append("aliment" + Integer.toString(i) + "=" +params[0].get(i).toString()+"&");
        }
        // nom de la recette
        url.append("nomrecette="+params[0].get(nombre_aliments_possedes-2).toString().replaceAll(" ","_"));
        url.append("&email="+params[0].get(nombre_aliments_possedes-1).toString());
        //nombre d'aliments que l'utilisateur à sélectionné
       url.append("&total=" + Integer.toString(nombre_aliments_possedes-2));

        //requête
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(url.toString());

        try {

            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            int status = response.getStatusLine().getStatusCode();
            if (status==200){
                InputStream is= entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is,"UTF-8"),8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while((line = reader.readLine())!=null){
                    sb.append(line+"\n");
                }
                is.close();
                String result=sb.toString();
                //décomposer en objets JSON
                String[] array= {result};
                //retourne tableau ds recettes disponibles
                return array;
            }
            else{

            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;


    }

}
