package zlisproduction.finistonassiette.selectionaliments.barcodescanner;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import zlisproduction.finistonassiette.R;

/**
 * Created by Florian.S on 05/06/2015.
 * Cette classe sera affichée sur une même page que le produit scanné par l'utilisateur lors de l'utilisation du scanner
 */
public class ProductResultDisplayer extends Fragment {

    private TextView mTitle = null;
    private TextView mCategories = null;
    private Context context = null;
    private String mScanContent = null;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = activity.getApplicationContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View Layout = inflater.inflate(R.layout.product_info, container, false);

        mTitle = (TextView) Layout.findViewById(R.id.title);
        mCategories = (TextView) Layout.findViewById(R.id.categories);
        getAndDisplayResult();

        return Layout;
    }

    public void getAndDisplayResult(){
        Bundle bundle = new Bundle();
        bundle = this.getArguments();
        String ProductDatas = bundle.getString("Product");
        getCategorieFromJSON(ProductDatas);
    }

    protected String[] getCategorieFromJSON(String pDatasProduct) {
        String[] Categories = null;
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
                } else {
                    // String categories = c.getString("categories");
                    Categories = StringToArray(c.getString("categories"));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
       /* int j = 0;
        String result = null;
        int size = Categories.length;
        while( j != size ){
            result = result +" "+ Categories[j];
            j++;
        }*/
        return Categories;
    }

    public String[] StringToArray(String pToSeparate){
        String[] categories = pToSeparate.split(",");
        int i = 0;
        for(String s: categories){
            categories[i] = s;
            i++;
        }
        return categories;
    }

}
