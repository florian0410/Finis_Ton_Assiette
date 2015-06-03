package zlisproduction.finistonassiette.recette;

//test
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import zlisproduction.finistonassiette.R;

/**
 * Created by Thibaut on 24/05/2015.
 */

public class Information extends Fragment {


    //attribut par défaut
    Instanciation instancie=null;
    Requete requete =null;
    AnalyseResultat analyse_resultat=null;
    ArrayList<String> result= new ArrayList<String>();


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View Layout= inflater.inflate(R.layout.information_layout, container, false);
        requete=new ConsulterRecette();
        result.add("Salade_de_riz");
        requete.execute(result);

        // Inflate the layout for this fragment
        return Layout;
    }






    public void envoyerRequete(ArrayList pArray){
        this.requete.envoyerRequete(pArray);
    }
/*
    public void analyserResultat(){
        this.analyse_resultat.parseData();
    }*/

    public void instanciationRecette(){
        this.instancie.instancie();
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

    //public void setRequete(Requete requete) {
    //this.requete = requete;
    //}

    public AnalyseResultat getAnalyse_resultat() {
        return analyse_resultat;
    }

    public void setAnalyse_resultat(AnalyseResultat analyse_resultat) {
        this.analyse_resultat = analyse_resultat;
    }
}

