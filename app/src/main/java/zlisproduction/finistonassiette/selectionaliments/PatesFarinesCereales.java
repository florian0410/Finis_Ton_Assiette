package zlisproduction.finistonassiette.selectionaliments;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.LinearGradient;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import zlisproduction.finistonassiette.R;

/**
 * Created by Thibaut on 16/05/2015.
 */
public class PatesFarinesCereales extends Fragment implements View.OnClickListener {

    private Button pate;
    private Button farine;
    private Button cereales;
    Fragment fragment = null;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Changer le titre de la barre d'action
        ActionBar actionbar = getActivity().getActionBar();
        actionbar.setTitle(getResources().getString(R.string.Pate_et_Farine));
        View lLayout =  inflater.inflate(R.layout.pates_farine_cereales_layout,container,false);

          /*
        déserialisation objets
         */
        pate=(Button) lLayout.findViewById(R.id.pate);
        pate.setOnClickListener(this);
        farine=(Button) lLayout.findViewById((R.id.farine));
        farine.setOnClickListener(this);
        cereales=(Button) lLayout.findViewById((R.id.cereales));
        cereales.setOnClickListener(this);

        return lLayout;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.pate:
                fragment = new Pates();
                break;
            case R.id.farine:
                fragment = new Farine();
                break;
            case R.id.cereales:
                fragment = new Cereale();
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
            Log.e("PateFarinesCereales", "Error in creating fragment");
        }
    }
}
