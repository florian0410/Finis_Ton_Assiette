package zlisproduction.finistonassiette.recette;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.HashMap;

import zlisproduction.finistonassiette.R;

/**
 * Created by Thibaut on 13/06/2015.
 */
public class AffichageCompteUtilisateur extends Instanciation{

    private HashMap<String,String> data= null;

    public AffichageCompteUtilisateur(HashMap<String,String> pData){
        data= pData;

    }

    private View vue =null;
    TextView pseudo = null;
    TextView motdepasse = null;
    TextView adressemail = null;
    TextView recetteconsultees = null;
    TextView recettescrees = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        vue = inflater.inflate(R.layout.affichagecompteutilisateurlayout, container, false);

        pseudo = (TextView)vue.findViewById(R.id.pseudovalue);
        pseudo.setText(data.get("pseudo"));

        motdepasse = (TextView)vue.findViewById(R.id.mdpvalue);
        motdepasse.setText(data.get("mot_de_passe"));

        adressemail = (TextView)vue.findViewById(R.id.mailadressevalue);
        adressemail.setText(data.get("adresse_mail"));

        recetteconsultees = (TextView)vue.findViewById(R.id.recetteconsulteesvalues);
        recetteconsultees.setText(data.get("recette_consultation"));

        recettescrees = (TextView)vue.findViewById(R.id.recettecreesvalue);
        recettescrees.setText(data.get("recette_creee"));


        return  vue;
    }
}
