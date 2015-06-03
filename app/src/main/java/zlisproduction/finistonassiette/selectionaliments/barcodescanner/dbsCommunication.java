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
import java.util.zip.Checksum;

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
            toast = Toast.makeText(pContext.getApplicationContext(), "Connexion internet OK", Toast.LENGTH_SHORT);
            toast.show();
            if(checkScan(pResult,pContext) == false){
                return false;
            }
        } else {
            toast = Toast.makeText(pContext.getApplicationContext(),
                    "Connexion internet indisponible", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
        toast.show();
        return true;
    }

    public static boolean isConnected(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            if(!isResolvable("fr.openfoodfacts.org")){
                return false;
            }
            return true;
        }
        return false;
    }

    public static boolean isResolvable(String hostname) {
        String netAddress = null;
        try {
            netAddress = new NetTask().execute(hostname).get();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static class NetTask extends AsyncTask<String, Integer, String>
    {
        @Override
        protected String doInBackground(String... params)
        {
            InetAddress addr = null;
            try
            {
                addr = InetAddress.getByName(params[0]);
            }

            catch (UnknownHostException e)
            {
                e.printStackTrace();
            }
            return addr.getHostAddress();
        }
    }
    public static boolean canConnect(InetAddress address, int port) {
        Socket socket = new Socket();

        SocketAddress socketAddress = new InetSocketAddress(address, port);

        try {
            // Only try for 2 seconds before giving up
            socket.connect(socketAddress, 2000);
        }
        catch (IOException e) {
            // Something went wrong during the connection
            return false;
        }
        finally {
            // Always close the socket after we're done
            if (socket.isConnected()) {
                try {
                    socket.close();
                }
                catch (IOException e) {
                    // Nothing we can do here
                    e.printStackTrace();
                }
            }
        }

        return true;
    }
}
