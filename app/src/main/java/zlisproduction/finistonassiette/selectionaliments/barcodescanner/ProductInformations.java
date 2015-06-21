package zlisproduction.finistonassiette.selectionaliments.barcodescanner;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

import zlisproduction.finistonassiette.MainActivity;
import zlisproduction.finistonassiette.R;
import zlisproduction.finistonassiette.imagefromurl.ImageLoader;

/**
 * Created by Florian.S on 02/06/2015.
 */
public class ProductInformations extends Fragment {
    private Context context = null;
    private TextView mTitle = null;
    private TextView mCategories = null;
    private ImageView mImage = null;
    private Button mNewScanButton = null;
    private String mScanContent = null;
    private String SourceURL = "http://fr.openfoodfacts.org/api/v0/produit/";   // source avec code barre manquant
    private String DynamicURL = null;   // String permettant d'avoir une URL changeante
    private int loader = R.drawable.ic_loader;
    private boolean isScan = false;
    private boolean isBackground;
    private View Layout = null;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = activity.getApplicationContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        isScan = false;
        Layout = inflater.inflate(R.layout.product_info, container, false);


        mTitle = (TextView) Layout.findViewById(R.id.title);
        mCategories = (TextView) Layout.findViewById(R.id.categories);
        mImage = (ImageView) Layout.findViewById(R.id.product_picture);
        mNewScanButton = (Button) Layout.findViewById(R.id.start_scan_button);
        mNewScanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isScan = true;
                IntentIntegrator integrator = IntentIntegrator.forFragment(ProductInformations.this);
                integrator.setCaptureActivity(CaptureActivityOrientation.class);
                integrator.setOrientationLocked(true);  // verrouillage de l'orientation
                integrator.initiateScan();
            }
        });
        return Layout;
    }

    public void SetIsBackground(boolean pValue){
        isBackground = pValue;
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle bundle = new Bundle();
        bundle = this.getArguments();
        // Recherche sur openfoodfact aliment
        String ProductDatas = bundle.getString("Product");
        getJsonDatas(ProductDatas);
    }


    @Override
    public void onStop(){
        super.onStop();
        // Quand on quitte ce fragment autre que pour un scan, on retire le second pour éviter les bugs
        if(!isScan &&  !isBackground){
            RemoveSecondFragment();
        }
    }

    public  void onWindowFocusChanged(boolean hasFocus){

    }

    /*
    * Quand on reçevra un résultat, on instanciera un nouveau fragment affichant celui-ci.
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        String scanContent = null;
        String scanFormat = null;
        Layout.findViewById(R.id.loadingPanel).setVisibility(View.VISIBLE);
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(dbsCommunication.checkScanAnswer(scanningResult, context)) {
            if (scanningResult != null) {
                // Récupérer le contenu
                scanContent = scanningResult.getContents();
                // Récupérer le format du barcode lu
                scanFormat = scanningResult.getFormatName();
            }
            //DynamicURL = "http://fr.openfoodfacts.org/api/v0/produit/3240930213508";
            DynamicURL  = SourceURL +scanContent;
            new JSONParse().execute();  // l'asynctask finis l'action pour passer au fragment suivant normalement
        }
    }


    private class JSONParse extends AsyncTask<String, String, JSONObject> {
        @Override
        protected JSONObject doInBackground(String... args) {
            JSONParser jParser = new JSONParser();

            // Getting JSON from URL
            JSONObject json = jParser.getJSONFromUrl(DynamicURL);
            return json;
        }
        @Override
        protected void onPostExecute(JSONObject json) {
            SendDatasToNextFragment(json);
        }
    }


    protected void getJsonDatas(String pDatasProduct) {
        try {
            JSONObject json = new JSONObject(pDatasProduct);
            // Getting JSON Array
            // name = json.getJSONArray("contacts");   // Quand démarre par [
            // Exception utilse quand page web non JSON ou pas de connectivité malgrés wifi
            int status = json.getInt("status");

            // Check detection produit
            if (status == 0) {
                mTitle.setText(context.getString(R.string.produit_non_reconnu));
                mCategories.setText("Code barre: " + mScanContent);
            }
            else {
                JSONObject c = json.getJSONObject("product");   // quand démarre par { ou quand une seule case

                // Check si le produit est incomplet au niveau infos
                String creator = c.getString("creator");
                if (creator == "null") {
                    mTitle.setText(context.getString(R.string.produit_non_reconnu));
                    mCategories.setText("Code barre :" + mScanContent);
                }
                else {
                    // Storing  JSON item in a Variable
                    String title = c.getString("product_name");
                    String image_url = c.getString("image_url");
                    String categories = c.getString("categories");
                    String brands = c.getString("brands");
                    String quantity = c.getString("quantity");

                    String customTitle = title + " - " + brands + " - " + quantity;
                    //Set JSON Data in TextView
                    mTitle.setText(customTitle);
                    mCategories.setText(categories);
                    ImageLoader imgLoader = new ImageLoader(context);
                    imgLoader.DisplayImage(image_url, loader, mImage);
                }
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param json contient la donnée à envoyer
     *             Cette fonction permet l'envoi de l'élément json lu
     */
    public void SendDatasToNextFragment(JSONObject json){
        Fragment fragment = new ProductInformations();
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

    private void RemoveSecondFragment(){
        FragmentManager fm = getFragmentManager();
        if(fm.findFragmentById(R.id.frame_container2) != null ) {
            fm.beginTransaction().remove(getFragmentManager().findFragmentById(R.id.frame_container2)).commit();
        }
    }
}
