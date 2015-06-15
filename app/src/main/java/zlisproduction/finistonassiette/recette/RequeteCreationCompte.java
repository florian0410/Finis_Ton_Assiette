package zlisproduction.finistonassiette.recette;

import android.util.Log;

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
 * Created by Thibaut on 12/06/2015.
 */
public class RequeteCreationCompte extends Requete {


    public RequeteCreationCompte(){

    }

    @Override
    public void envoyerRequete(ArrayList pData) {

    }

    @Override
    protected String[] doInBackground(ArrayList<String>... params) {

        //Construction de l'url
        String url ="http://finistonassiette.ddns.net/requetephp/utilisateur/creationCompteUtilisateur.php?pseudo="+params[0].get(0)+"&mdp="+params[0].get(1)+"&mail="+params[0].get(2);

        //requête
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(url);

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
    @Override

    protected void onPostExecute(String[] pArray) {


    }




}
