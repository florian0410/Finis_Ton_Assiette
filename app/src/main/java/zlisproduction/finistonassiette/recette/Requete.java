package zlisproduction.finistonassiette.recette;

import android.os.AsyncTask;
import android.widget.ProgressBar;

import java.util.ArrayList;

/**
 * Created by Thibaut on 24/05/2015.
 */
public abstract class Requete extends AsyncTask<Void,ProgressBar,Boolean> {

    public abstract  void envoyerRequete(ArrayList pData);
}
