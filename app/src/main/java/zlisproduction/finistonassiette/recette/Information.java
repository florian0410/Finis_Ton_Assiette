package zlisproduction.finistonassiette.recette;
import android.app.Activity;

//test
import android.os.Bundle;

import java.util.ArrayList;

/**
 * Created by Thibaut on 24/05/2015.
 */

public class Information extends Activity {


    //attribut par défaut
    Instanciation instancie=null;
    Requete requete =null;
    AnalyseResultat analyse_resultat=null;
    ArrayList<String> result= new ArrayList<String>();




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requete=new ConsulterRecette();
        result.add("50");
        requete.execute(result);
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

