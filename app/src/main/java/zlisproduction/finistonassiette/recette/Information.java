package zlisproduction.finistonassiette.recette;

//test
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import zlisproduction.finistonassiette.R;

/**
 * Created by Thibaut on 24/05/2015.
 */

public class Information extends Fragment {


    //attribut par défaut
    Instanciation instancie = null;
    Requete requete = null;
    AnalyseResultat analyse_resultat = null;

    /**
     * Définition des paramètres par défaut
     */
    public Information(){


    }

    ArrayList<String> result = new ArrayList<String>();
    ProgressBar progressBar = null;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View Layout= inflater.inflate(R.layout.information_layout, container, false);
     /*   //comportements par défaut
        progressBar= (ProgressBar) Layout.findViewById(R.id.progressBar);

        requete=new ConsulterRecette();
        result.add("oeuf");
        try {
            //envoie de la requête et le resultat est stocké dans res
            String[] res= requete.execute(result).get();
            //analyse du resultat
            analyse_resultat= new JsonFormat(res);
            try {
                analyse_resultat.demande_consulter_recette();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        // http://www.tutos-android.com/parcelable-android
*/

        progressBar.setVisibility(View.GONE);


        // Inflate the layout for this fragment
        return Layout;
    }



    public Instanciation getInstancie() {
        return instancie;
    }

    public void setInstancie(Instanciation instancie) {
        this.instancie = instancie;
    }

    public Requete getRequete() {
        return requete;
    }

    public void setRequete(Requete requete) {
        this.requete = requete;
    }

    public AnalyseResultat getAnalyse_resultat() {
        return analyse_resultat;
    }

    public void setAnalyse_resultat(AnalyseResultat analyse_resultat) {
        this.analyse_resultat = analyse_resultat;
    }

    public ArrayList<String> getResult() {
        return result;
    }

    public void setResult(ArrayList<String> result) {
        this.result = result;
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }
}

