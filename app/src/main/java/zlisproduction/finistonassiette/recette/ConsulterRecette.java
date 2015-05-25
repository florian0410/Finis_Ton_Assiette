package zlisproduction.finistonassiette.recette;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thibaut on 25/05/2015.
 */
public class ConsulterRecette extends AsyncTask<ArrayList<String>, ProgressBar, String> implements Requete {
    private static final String TAG = "ConsulterRecette";
    private InputStream is= null;
    private String result="";


    @Override
    public void envoyerRequete(ArrayList pData) {
    }

    public ConsulterRecette(Information pinfo){
    }


    @Override
    protected String doInBackground(ArrayList<String>... params) {

        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost("http://finistonassiette.ddns.net/phpMongoDb.php");

        //nombre d'ingrédients séléctionnés
        int nb_aliments_choisis =params.length;
        //création de la liste nom/valeur
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(nb_aliments_choisis);
        String name= "ingredient";

        String value= null;
        int i=0;
        for (i=0; i<nb_aliments_choisis;i++){

            value=params[i].toString();
            nameValuePairs.add(new BasicNameValuePair(name+Integer.toString(i),value));
        }

        nameValuePairs.add(new BasicNameValuePair("total",Integer.toString(i)));

        try {
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(nameValuePairs);
            httppost.setEntity(formEntity);
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            int status = response.getStatusLine().getStatusCode();
            if (status==200){
                Log.i(TAG,"Données recues");
                is= entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while((line = reader.readLine())!=null){
                    sb.append(line+"\n");
                }
                is.close();
                result=sb.toString();
                return result;
            }
            else{
                Log.i(TAG,"erreur dans la récupération des données");
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
