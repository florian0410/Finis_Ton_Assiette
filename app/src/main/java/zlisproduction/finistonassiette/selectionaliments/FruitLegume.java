package zlisproduction.finistonassiette.selectionaliments;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import zlisproduction.finistonassiette.R;

/**
 * Created by Florian on 15/05/2015.
 */
public class FruitLegume extends Fragment implements View.OnClickListener{
    private Button fruit;
    private Button legumes;
    private Fragment fragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Changer le titre de la barre d'action
        ActionBar actionbar = getActivity().getActionBar();
        actionbar.setTitle(getResources().getString(R.string.Fruits_et_Legumes));

        View lLayout = inflater.inflate(R.layout.fruit_legumes_layout, container, false);
          /*
        déserialisation objets
         */
        fruit=(Button) lLayout.findViewById(R.id.fruit);
        fruit.setOnClickListener(this);
        legumes=(Button) lLayout.findViewById((R.id.Legumes));
        legumes.setOnClickListener(this);

        return lLayout;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.fruit:
                fragment = new Fruit();
                break;
            case R.id.Legumes:
                fragment = new Legume();
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
            Log.e("FruitLegume", "Error in creating fragment");
        }
    }
}
