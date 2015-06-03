package zlisproduction.finistonassiette.selectionaliments.barcodescanner;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import zlisproduction.finistonassiette.R;


/**
 * A placeholder fragment containing a simple view.
 */
public class ScannerMainFragment extends Fragment {

    private Context context = null;
    private String mUrlPart = "http://fr.openfoodfacts.org/api/v0/produit/";

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = activity.getApplicationContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View Layout = inflater.inflate(R.layout.scanner_fragment_main, container, false);

        Button mScannerAccess = (Button) Layout.findViewById(R.id.scanner_button);

        mScannerAccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        String scanContent = null;
        String scanFormat = null;
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(dbsCommunication.checkScanAnswer(scanningResult, context)) {
            if (scanningResult != null) {
                // Récupérer le contenu
                scanContent = scanningResult.getContents();
                // Récupérer le format du barcode lu
                scanFormat = scanningResult.getFormatName();
            }

            // Changement de fragment
            Fragment fragment = new ProductDisplay();

            // Ajout des information supplémentaires scannées
            Bundle bundle = new Bundle();
            bundle.putString("Content", scanContent);
            bundle.putString("Format", scanFormat);
            fragment.setArguments(bundle);

            FragmentTransaction transaction = getFragmentManager().beginTransaction();

            transaction.replace(R.id.frame_container, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}


