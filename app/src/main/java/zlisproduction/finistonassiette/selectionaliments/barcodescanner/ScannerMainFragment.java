package zlisproduction.finistonassiette.selectionaliments.barcodescanner;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONObject;

import zlisproduction.finistonassiette.CommunicateWithFragment;
import zlisproduction.finistonassiette.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class ScannerMainFragment extends Fragment {

    private Context context = null;
    private String SourceURL = "http://fr.openfoodfacts.org/api/v0/produit/";   // source avec code barre manquant
    private String DynamicURL = null;   // String permettant d'avoir une URL changeante
    private View Layout = null;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = activity.getApplicationContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Layout = inflater.inflate(R.layout.scanner_fragment_main, container, false);

        Button mScannerAccess = (Button) Layout.findViewById(R.id.scanner_button);

        mScannerAccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommunicateWithFragment.SetNewActivity(true);
                IntentIntegrator integrator = IntentIntegrator.forFragment(ScannerMainFragment.this);
                integrator.setCaptureActivity(CaptureActivityOrientation.class);
                integrator.setOrientationLocked(true);  // verrouillage de l'orientation
                integrator.initiateScan();
            }
        });
        return Layout;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        CommunicateWithFragment.SetNewActivity(false);
        String scanContent = null;
        String scanFormat = null;
        Layout.findViewById(R.id.loadingPanel).setVisibility(View.VISIBLE);
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(dbsCommunication.checkScanAnswer(scanningResult, context)) {
            // if (scanningResult != null) {
                // Récupérer le contenu
                scanContent = scanningResult.getContents();
                // Récupérer le format du barcode lu
                scanFormat = scanningResult.getFormatName();
            // }
            DynamicURL = SourceURL + scanContent;
            new JSONParse().execute();  // l'asynctask finis l'action pour passer au fragment suivant normalement
        }
    }


    /**
     *
     * @param json contient la donnée à envoyer
     *             Cette fonction permet l'envoi de l'élément json lu
     */
    public void SendDatasToNextFragment(JSONObject json){
        Fragment fragment =  new ProductInformations();
        Fragment fragment2 = new ProductResultDisplayer();
        if(json != null) {
            String ProductDatas = json.toString();

            // Ajout des information supplémentaires scannées
            Bundle bundle = new Bundle();
            bundle.putString("Product", ProductDatas);
            fragment.setArguments(bundle);
            fragment2.setArguments(bundle);
            FragmentManager fm = getFragmentManager();
            fm.beginTransaction().addToBackStack(null).replace(R.id.frame_container,fragment).commit();
            fm.beginTransaction().addToBackStack(null).replace(R.id.frame_container2,fragment2).commit();
        }
        else{
            Toast toast = Toast.makeText(context.getApplicationContext(),"Impossible de se connecter : Page web vide ( json = null)", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    private class JSONParse extends AsyncTask<String, String, JSONObject> {
        @Override
        protected JSONObject doInBackground(String... args) {
            JSONParser jParser = new JSONParser();

            // Getting JSON from URL
            //DynamicURL = "http://fr.openfoodfacts.org/api/v0/produit/3240930213508";
            JSONObject json = jParser.getJSONFromUrl(DynamicURL);
            return json;
        }
        @Override
        protected void onPostExecute(JSONObject json) {
            SendDatasToNextFragment(json);
        }
    }
}


