package zlisproduction.finistonassiette.recette;

import android.os.AsyncTask;
import android.widget.ProgressBar;

import java.util.ArrayList;

import zlisproduction.finistonassiette.selectionaliments.Result;

/**
 * Created by Thibaut on 24/05/2015.
 */
public interface Requete  {

    public void envoyerRequete(ArrayList pData);
}
