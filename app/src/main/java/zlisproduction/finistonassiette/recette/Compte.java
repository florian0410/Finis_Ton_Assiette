package zlisproduction.finistonassiette.recette;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zlisproduction.finistonassiette.R;

/**
 * Created by Thibaut on 12/06/2015.
 */
public class Compte extends Fragment {

    /**
     * Constructeur par défaut
     */
    public Compte(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.comptelayout, container, false);
    }


}
