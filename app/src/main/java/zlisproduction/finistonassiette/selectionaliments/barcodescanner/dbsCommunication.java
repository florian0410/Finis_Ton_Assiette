package zlisproduction.finistonassiette.selectionaliments.barcodescanner;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

import com.google.zxing.integration.android.IntentResult;


/**
 * Created by Florian.S on 30/05/2015.
 */
public class dbsCommunication {

    private static Toast toast = null;

    public static boolean checkNetworkState(Context pContext){
        boolean netCheck = false;
        ConnectivityManager cm = (ConnectivityManager) pContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (!isConnected(pContext)) {
            // There are no active networks.
            netCheck = false;
        }
        else {
            netCheck = true;
        }
        return netCheck;
    }
    /*
     *  Vérifie si le scan réalisé renvoi bien une information
     */
    public static boolean checkScan(IntentResult pResult, Context pContext){
        if (pResult == null) {
            toast = Toast.makeText(pContext.getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
        return true;
    }

    /*
      * Regarde l'état du réseau et si le code barre est valide
      * @param : pResult, le résultat du scan
      * @param pContext : Le contexte de l'appli
      * @return : Si oui, retourne true
     */

    public static boolean checkScanAnswer(IntentResult pResult,Context pContext){
        if (dbsCommunication.checkNetworkState(pContext)) {
            // toast = Toast.makeText(pContext.getApplicationContext(), "Connexion internet OK", Toast.LENGTH_SHORT);
            // toast.show();
            if(checkScan(pResult,pContext) == false){
                return false;
            }
        } else {
            toast = Toast.makeText(pContext.getApplicationContext(),
                    "Connexion internet indisponible", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
        return true;
    }

    public static boolean isConnected(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }



}
