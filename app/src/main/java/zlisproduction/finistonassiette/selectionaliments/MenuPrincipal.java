package zlisproduction.finistonassiette.selectionaliments;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

import zlisproduction.finistonassiette.R;

/**
 * Created by Florian on 15/05/2015.
 */
    public class MenuPrincipal extends Fragment implements View.OnClickListener{
    /*
    déclaration des boutons
     */
    private Button incontournables;
    private Button patesFarinesCereales;
    private Button viandePoissons;
    private Button produitsLaitiers;
    private Button fruitlegumes;
    private Fragment fragment;

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
        incontournables=(Button) lLayout.findViewById(R.id.incontournable);
        incontournables.setOnClickListener(this);

        patesFarinesCereales=(Button) lLayout.findViewById(R.id.PatesFarinesCereales);
        patesFarinesCereales.setOnClickListener(this);

        viandePoissons=(Button) lLayout.findViewById(R.id.viandePoissons);
        viandePoissons.setOnClickListener(this);

        produitsLaitiers=(Button) lLayout.findViewById(R.id.produitsLaitiers);
        produitsLaitiers.setOnClickListener(this);

        fruitlegumes=(Button) lLayout.findViewById(R.id.fruitlegumes);
        fruitlegumes.setOnClickListener(this);

        // Instead of :
        // findViewById(R.id.someGuiElement);
        return lLayout; // We must return the loaded Layout
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.incontournable:
                fragment = new Incontournable();
                break;

            case R.id.PatesFarinesCereales:
                fragment = new PatesFarinesCereales();
                break;

            case R.id.viandePoissons:
                fragment = new ViandePoisson();
                break;

            case R.id.produitsLaitiers:
                fragment = new ProduitLaitier();
                break;

            case R.id.fruitlegumes:
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
