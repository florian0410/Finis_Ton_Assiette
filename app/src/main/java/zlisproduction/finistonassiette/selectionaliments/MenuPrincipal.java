package zlisproduction.finistonassiette.selectionaliments;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import zlisproduction.finistonassiette.R;

/**
 * Created by Florian on 15/05/2015.
 */
    public class MenuPrincipal extends Fragment implements View.OnClickListener{
    /*
    déclaration des boutons
     */
    private ImageView incontournables;
    private ImageView patesFarinesCereales;
    private ImageView viandePoissons;
    private ImageView produitsLaitiers;
    private ImageView fruitlegumes;
    private Fragment fragment;
    private Context context = null;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = activity.getApplicationContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Changer le titre de la barre d'action
        ActionBar actionbar = getActivity().getActionBar();
        actionbar.setTitle(getResources().getString(R.string.Menu_Principal));
       // FragmentActivity    faActivity  = (FragmentActivity)    super.getActivity();
        View lLayout = inflater.inflate(R.layout.menu_principal_layout, container, false);
        // Of course you will want to faActivity and llLayout in the class and not this method to access them in the rest of
        // the class, just initialize them here

          /*
        Désérialisation des boutons et définition de l'écouteur
         */
        incontournables=(ImageView) lLayout.findViewById(R.id.btn_blue);
        incontournables.setOnClickListener(this);

        patesFarinesCereales=(ImageView) lLayout.findViewById(R.id.btn_green);
        patesFarinesCereales.setOnClickListener(this);

        viandePoissons=(ImageView) lLayout.findViewById(R.id.btn_indigo);
        viandePoissons.setOnClickListener(this);

        produitsLaitiers=(ImageView) lLayout.findViewById(R.id.btn_orange);
        produitsLaitiers.setOnClickListener(this);

        fruitlegumes=(ImageView) lLayout.findViewById(R.id.btn_yellow);
        fruitlegumes.setOnClickListener(this);

        // Instead of :
        // findViewById(R.id.someGuiElement);

        return lLayout; // We must return the loaded Layout

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_blue:
                fragment = new Incontournable();
                break;

            case R.id.btn_green:
                fragment = new PatesFarinesCereales();
                break;

            case R.id.btn_indigo:
                fragment = new ViandePoisson();
                break;

            case R.id.btn_orange:
                fragment = new ProduitLaitier();
                break;

            case R.id.btn_yellow:
               fragment = new FruitLegume();
                break;
        }
        if (fragment != null) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_container, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else {
            // error in creating fragment
            Log.e("MenuPrincipal", "Error in creating fragment");
        }

    }
}
