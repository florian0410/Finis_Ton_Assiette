package zlisproduction.finistonassiette.recette;
import android.util.Log;
import android.widget.ProgressBar;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;


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

public  class ConsulterRecette extends Requete {

    private static final String TAG = "ConsulterRecette";
    private InputStream is= null;
    private String result="";

    public ConsulterRecette(){

    }

    @Override
    public void envoyerRequete(ArrayList pData) {

    }



    @Override
    protected String[] doInBackground(ArrayList<String>... params) {

        ArrayList <String> arr= params[0];
        int nombre_aliments= arr.size();
        StringBuilder stringBuilder= new StringBuilder("http://finistonassiette.ddns.net/consulterRecette.php?");
        int i=0;

        for (i=0; i<nombre_aliments; i++){
            stringBuilder.append("aliment" + Integer.toString(i) + "=" + arr.get(i).toString().replace("[", "").replace("]","").replace(" ","%20")+"&");
        }

        stringBuilder.append("total="+Integer.toString(nombre_aliments));

        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(stringBuilder.toString());

        try {

            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            int status = response.getStatusLine().getStatusCode();
            if (status==200){
                Log.i(TAG,"Données recues");
                is= entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is,"UTF-8"),8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while((line = reader.readLine())!=null){
                    sb.append(line+"\n");
                }
                is.close();
                result=sb.toString();
                //décomposer en objets JSON
                String[] array= result.split("thisisaseparatorbetweenpicturesandreceipies");
                //retourne tableau ds recettes disponibles
                return array;
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
    @Override
    protected void onPostExecute(String[] pArray) {


    }

}
