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
import org.json.JSONException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import zlisproduction.finistonassiette.R;

/**
 * Created by Thibaut on 24/05/2015.
 */

public class Information extends Fragment {


    //Comportement du fragment
    Instanciation instancie = null;
    Requete requete = null;
    AnalyseResultat analyse_resultat = null;

    ArrayList<String> result = new ArrayList<String>();


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View Layout= inflater.inflate(R.layout.information_layout, container, false);




        // Inflate the layout for this fragment
        return Layout;
    }

    /**
     * Lance la requête
     * @param pRes
     * @return String[] result or null if the request does not proceed
     */
    public String[] executeRequest(ArrayList<String> pRes){
        try {
            return requete.execute(pRes).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Retourne le resultat de la reqête analysé
     * @return ArrayList<HashMap<String, Object>>
     */
    public ArrayList<HashMap<String, Object>> analyse_result(){
        try {
           return analyse_resultat.demande_consulter_recette();
        } catch (JSONException e) {
            e.printStackTrace();
        }
       return  null;
    }

    /**
     * Changement de fragment
     * @param tmp
     */
    public void changementFragment(ArrayList<HashMap<String, Object>> tmp,FragmentManager pFrag){
        Bundle args = new Bundle();
        args.putSerializable("ingredients", tmp);
        instancie.setArguments(args);
        // remplaçement du gragment
        if (instancie != null) {
            FragmentManager ft = pFrag;
            FragmentTransaction transaction =ft.beginTransaction();
            transaction.replace(R.id.frame_container, instancie);
            transaction.addToBackStack(null);
            transaction.commit();
        }

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


}

