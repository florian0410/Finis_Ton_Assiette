package zlisproduction.finistonassiette.recette;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import zlisproduction.finistonassiette.R;

/**
 * Created by Thibaut on 24/05/2015.
 *
 */
public class ConstructeurDefaut extends Fragment implements Instanciation  {

   private String[] recettes= null;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View Layout= inflater.inflate(R.layout.information_layout, container, false);



        // / Inflate the layout for this fragment
        return Layout;
    }


    @Override
    public void instancie(String[] pArray) {

    }
}
