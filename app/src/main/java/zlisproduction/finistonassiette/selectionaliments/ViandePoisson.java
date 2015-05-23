package zlisproduction.finistonassiette.selectionaliments;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import zlisproduction.finistonassiette.R;

/**
 * Created by Florian on 15/05/2015.
 */

public class ViandePoisson extends Fragment implements View.OnClickListener{

    private Button viande;
    private Button poisson;
    private Fragment fragment = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Changer le titre de la barre d'action
        ActionBar actionbar = getActivity().getActionBar();
        actionbar.setTitle(getResources().getString(R.string.Viande_et_Poisson));
        View lLayout = inflater.inflate(R.layout.viande_poisson_layout, container, false);

        viande=(Button) lLayout.findViewById(R.id.viande);
        viande.setOnClickListener(this);
        poisson=(Button)lLayout.findViewById(R.id.poissons);
        poisson.setOnClickListener(this);

        return lLayout;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.viande:
                fragment = new Viande();
                break;
            case R.id.poissons:
                fragment = new Poisson();
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
            Log.e("ViandePoisson", "Error in creating fragment");
        }
    }


}
